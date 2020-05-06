package com.rahil.SortGraph;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

class SortingGraph extends JPanel {

    static final int MAX_ARRAY_SIZE = 10_000;

    private static final int GRAPH_WIDTH = 640, GRAPH_HEIGHT = 500;
    private static final SortingThread.SortingFunction[] SORTING_FUNCTIONS = new SortingThread.SortingFunction[]{
            (arr) -> {
                Arrays.sort(arr);
                return 0;
            },
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
    private static final Color[] COLORS = new Color[]{
            new Color(0, 0, 0, 0.4f),
            new Color(1, 0, 0, 0.4f),
            new Color(0, 1, 0, 0.4f),
            new Color(0, 0, 1, 0.4f),
            new Color(1, 1, 0, 0.4f),
            new Color(1, 0, 1, 0.4f)
    };

    double timeXScale = (double) GRAPH_WIDTH / MAX_ARRAY_SIZE, timeYScale = GRAPH_HEIGHT / 1e-2;
    double iterationsXScale = (double) GRAPH_WIDTH / MAX_ARRAY_SIZE, iterationsYScale = GRAPH_HEIGHT / 1e5;

    JFrame frame;
    double[][] times;
    double[][] movingAverages;
    double[][] iterations;

    SortingGraph() {
        super();
        setPreferredSize(new Dimension(GRAPH_WIDTH * 2, GRAPH_HEIGHT));
        setBackground(Color.GRAY);
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
    }

    public static void main(String[] args) {
        SortingThread.graph = new SortingGraph();
        SortingThread.graph.times = new double[SORTING_FUNCTIONS.length][MAX_ARRAY_SIZE];
        SortingThread.graph.movingAverages = new double[SORTING_FUNCTIONS.length][MAX_ARRAY_SIZE];
        SortingThread.graph.iterations = new double[SORTING_FUNCTIONS.length][MAX_ARRAY_SIZE];
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
            sortingThreads[i].iterations = SortingThread.graph.iterations[i];
        }
        for (SortingThread thread : sortingThreads) {
            thread.start();
        }
        System.out.println("Started all threads.");
    }

    @Override
    synchronized public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(0, 0, timeXScale, timeYScale, movingAverages, g);
        drawGraph(GRAPH_WIDTH, 0, iterationsXScale, iterationsYScale, iterations, g);
    }

    void drawGraph(int x, int y, double scaleX, double scaleY, double[][] mat, Graphics g) {
        for (int i = 0; i < mat.length; ++i) {
            g.setColor(COLORS[i]);
            int prevY = (int) (GRAPH_HEIGHT - mat[i][0] * scaleY);
            int prevX = x;
            for (int j = 1; j < MAX_ARRAY_SIZE; j++) {
                int thisX = x + (int) (scaleX * j);
                int thisY = y + (int) (GRAPH_HEIGHT - mat[i][j] * scaleY);
                if (thisX < x || thisX >= x + GRAPH_WIDTH || thisY < y || thisY >= y + GRAPH_HEIGHT) {
                    continue;
                }
                g.drawLine(prevX, prevY, thisX, thisY);
                prevX = thisX;
                prevY = thisY;
            }
        }
    }
}
