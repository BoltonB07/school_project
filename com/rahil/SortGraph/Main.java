package com.rahil.SortGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.util.Arrays;

class Main {

    static final int MAX_ARRAY_SIZE = 10_000;

    // Size of each individual graph
    private static final int GRAPH_WIDTH = 450, GRAPH_HEIGHT = 450;

    // Space between the graphs
    private static final int PADDING_X = GRAPH_WIDTH / 10, PADDING_Y = GRAPH_HEIGHT / 10;

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
            new Color(0, 0, 0, 0.4f), // Black
            new Color(1, 0, 0, 0.4f), // Red
            new Color(0, 1, 0, 0.4f), // Green
            new Color(0, 0, 1, 0.4f), // Blue
            new Color(1, 1, 0, 0.4f), // Yellow
            new Color(1, 0, 1, 0.4f) // Purple
    };

    static double timeXScale = (double) GRAPH_WIDTH / MAX_ARRAY_SIZE;
    static double timeYScale = GRAPH_HEIGHT / 1e-2;

    static double iterationsXScale = (double) GRAPH_WIDTH / MAX_ARRAY_SIZE;
    static double iterationsYScale = GRAPH_HEIGHT / 1e5;

    static JPanel panel;

    public static void main(String[] args) {

        // Initializes the random arrays that will be sorted
        int[][] randomArrays = new int[MAX_ARRAY_SIZE][];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            randomArrays[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                randomArrays[i][j] = (int) (Math.random() * i);
            }
        }
        System.out.format("main: Finished making %d random arrays.%n", MAX_ARRAY_SIZE);

        // Initializes the descending order arrays that will be sorted
        int[][] descendingArrays = new int[MAX_ARRAY_SIZE][];
        for (int i = 0; i < MAX_ARRAY_SIZE; i++) {
            descendingArrays[i] = new int[i + 1];
            for (int j = 0; j < i + 1; j++) {
                descendingArrays[i][j] = i + 1 - j;
            }
        }
        System.out.format("main: Finished making %d descending arrays.%n", MAX_ARRAY_SIZE);

        SortingThread[] randomArrayThreads = new SortingThread[SORTING_FUNCTIONS.length];
        SortingThread[] descendingArrayThreads = new SortingThread[SORTING_FUNCTIONS.length];

        // Initializes the component that draws the graph
        panel = new JPanel() {
            @Override
            synchronized protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                drawGraph(0, 0, timeXScale, timeYScale, randomArrayThreads, (o) -> o.timeMovingAverages, g);
                drawGraph(GRAPH_WIDTH + PADDING_X, 0, iterationsXScale, iterationsYScale, randomArrayThreads,
                        (o) -> o.iterations
                        , g);
                drawGraph(0, GRAPH_HEIGHT + PADDING_Y, timeXScale, timeYScale, descendingArrayThreads,
                        (o) -> o.timeMovingAverages, g);
                drawGraph(GRAPH_WIDTH + PADDING_X, GRAPH_HEIGHT + PADDING_Y, iterationsXScale, iterationsYScale,
                        descendingArrayThreads,
                        (o) -> o.iterations, g);
            }
        };

        panel.setPreferredSize(new Dimension(GRAPH_WIDTH * 2 + PADDING_X, GRAPH_HEIGHT * 2 + PADDING_Y));
        panel.setBackground(Color.GRAY);

        // Initializes all the random array threads. Does not start them
        for (int i = 0; i < SORTING_FUNCTIONS.length; i++) {
            randomArrayThreads[i] = new SortingThread("Random Array " + NAMES[i], SORTING_FUNCTIONS[i], panel,
                    randomArrays);
        }

        // Initializes all the descending array threads. Does not start them
        for (int i = 0; i < SORTING_FUNCTIONS.length; i++) {
            descendingArrayThreads[i] = new SortingThread("Descending Array " + NAMES[i], SORTING_FUNCTIONS[i], panel
                    , descendingArrays);
        }

        // Initializes the object that gets called by the JFrame when the mouse wheel is moved
        MouseAdapter mouseListener = new MouseAdapter() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                Main.mouseWheelMoved(e);
            }
        };

        // Creates the swing window
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.addMouseWheelListener(mouseListener);
            frame.pack();
            frame.setVisible(true);
        });

        // Starts all the threads
        for (SortingThread thread : randomArrayThreads) {
            thread.start();
        }
        for (SortingThread thread : descendingArrayThreads) {
            thread.start();
        }

        System.out.println("Started all threads.\nHover over a graph and scroll to zoom in or out.");
    }

    static void drawGraph(int x, int y, double scaleX, double scaleY, SortingThread[] threads, FieldSelector selector, Graphics g) {
        for (int i = 0; i < threads.length; ++i) {
            g.setColor(COLORS[i]);
            double[] line = selector.getField(threads[i]);
            int prevY = (int) (y + GRAPH_HEIGHT - line[i] * scaleY);
            int prevX = x;
            for (int j = 1; j < MAX_ARRAY_SIZE; j++) {
                int thisX = x + (int) (scaleX * j);
                int thisY = y + (int) (GRAPH_HEIGHT - line[j] * scaleY);
                if (thisX < x || thisY >= y + GRAPH_HEIGHT) {
                    continue;
                }
                boolean shouldBreak = false;
                if (thisX >= x + GRAPH_WIDTH) {
                    thisX = x + GRAPH_WIDTH;
                    shouldBreak = true;
                }
                if (thisY < y) {
                    thisY = y;
                    shouldBreak = true;
                }
                g.drawLine(prevX, prevY, thisX, thisY);
                prevX = thisX;
                prevY = thisY;
                if (shouldBreak) {
                    break;
                }
            }
        }
    }

    static void mouseWheelMoved(MouseWheelEvent e) {
        int x = e.getX();
        if (0 < x && x < GRAPH_WIDTH) {
            int scroll = e.getWheelRotation();
            if (scroll > 0) {
                timeXScale *= 1.1;
                timeYScale *= 1.1;
            } else {
                timeXScale /= 1.1;
                timeYScale /= 1.1;
            }
        } else if (GRAPH_WIDTH < x && x < GRAPH_WIDTH * 2) {
            int scroll = e.getWheelRotation();
            if (scroll > 0) {
                iterationsXScale *= 1.1;
                iterationsYScale *= 1.1;
            } else {
                iterationsXScale /= 1.1;
                iterationsYScale /= 1.1;
            }
        }
        e.getScrollAmount();
    }

    interface FieldSelector {

        double[] getField(SortingThread thread);
    }
}
