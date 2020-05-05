package com.rahil.SortGraph;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

class SortingGraph extends JPanel {

    static final int MAX_ARRAY_SIZE = 10_000;

    private static final int GRAPH_WIDTH = 640, GRAPH_HEIGHT = 500;
    private static final double X_SCALE = (double) GRAPH_WIDTH / MAX_ARRAY_SIZE, Y_SCALE = GRAPH_HEIGHT / 1e-3;

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
    private static final Color[] COLORS = new Color[]{Color.BLACK, Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW,
            Color.ORANGE};

    JFrame frame;
    double[][] times;
    double[][] movingAverages;

    SortingGraph() {
        super();
        setPreferredSize(new Dimension(GRAPH_WIDTH, GRAPH_HEIGHT));
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        setBackground(Color.GRAY);
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
        drawGraph(0, 0, movingAverages, g);
    }

    void drawGraph(int x, int y, double[][] mat, Graphics g) {
        for (int i = 0; i < mat.length; ++i) {
            g.setColor(COLORS[i]);
            int prevY = (int) (GRAPH_HEIGHT - mat[i][0] * Y_SCALE);
            int prevX = 0;
            for (int j = 1; j < MAX_ARRAY_SIZE; j++) {
                int thisX = x + (int) (X_SCALE * j);
                int thisY = y + (int) (GRAPH_HEIGHT - mat[i][j] * Y_SCALE);
                if (thisX < x || thisX > x + GRAPH_WIDTH - 1 || thisY < y || thisY > y + GRAPH_HEIGHT - 1) {
                    continue;
                }
                g.drawLine(prevX, prevY, thisX, thisY);
                prevX = thisX;
                prevY = thisY;
            }
        }
    }
}
