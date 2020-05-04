package com.rahil.SortGraph;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

class SortingGraph extends JPanel {

    static final int MAX_ARRAY_SIZE = 10_000;

    private static final int WIDTH = 640, HEIGHT = 500;

    private static final SortingThread.SortingFunction[] SORTING_FUNCTIONS = new SortingThread.SortingFunction[]{
            Arrays :: sort,
            Sort :: Bubble,
            Sort :: Insertion,
            Sort :: Selection,
            Sort :: Merge,
            Sort :: Quick
            //Add method references to sorting algorithms in the format <Class name> :: <method name>
    };

    //Add names of the algorithms in the same order as above
    private static final String[] NAMES = new String[]{"Java Sort", "Bubble sort", "Insertion sort", "Selection sort"
            , "Merge sort", "Quick sort"};

    //Add colors of the graph for each algorithm in the same order as above
    private static final Color[] COLORS = new Color[]{Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.ORANGE};

    JFrame frame;
    double[][] times;
    double [][] movingAverages;

    SortingGraph() {
        super();
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
    }

    public static void main(String[] args) {
        SortingThread.graph = new SortingGraph();
        SortingThread.graph.times = new double[SORTING_FUNCTIONS.length][MAX_ARRAY_SIZE];
        SortingThread.graph.movingAverages = new double[SORTING_FUNCTIONS.length][MAX_ARRAY_SIZE];
        SortingThread.randomArrays = new int[MAX_ARRAY_SIZE][];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            SortingThread.randomArrays[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                SortingThread.randomArrays[i][j] = (int) (Math.random() * i);
            }
        }
        System.out.format("%s: Finished making %d random arrays.%n", Thread.currentThread().getName(), MAX_ARRAY_SIZE);
        SwingUtilities.invokeLater(() -> SortingThread.graph.frame.setVisible(true));
        SortingThread[] sortingThreads = new SortingThread[SORTING_FUNCTIONS.length];
        for (int i = 0; i < SORTING_FUNCTIONS.length; i++) {
            sortingThreads[i] = new SortingThread(SORTING_FUNCTIONS[i], NAMES[i]);
            sortingThreads[i].times = SortingThread.graph.times[i];
            sortingThreads[i].movingAverages = SortingThread.graph.movingAverages[i];
        }
        for (SortingThread thread : sortingThreads) {
            thread.start();
        }
        System.out.println("Started all threads.");
    }

    @Override
    synchronized public void paintComponent(Graphics g) {
        super.paintComponent(g);
        final double xScale = (double) WIDTH / MAX_ARRAY_SIZE, yScale = HEIGHT / 1e-3;
        for (int i = 0; i < SORTING_FUNCTIONS.length; ++i) {
            g.setColor(COLORS[i]);
            int prevY = (int) (times[i][0] * yScale);
            int prevX = 0;
            for (int j = 1; j < MAX_ARRAY_SIZE; j++) {
                int thisY = (int) (movingAverages[i][j] * yScale);
                int thisX = (int) (xScale * j);
                g.drawLine(prevX, HEIGHT - prevY, thisX, HEIGHT - thisY);
                prevX = thisX;
                prevY = thisY;
            }
        }
    }
}
