package com.rahil.SortGraph;

import java.util.Arrays;

class SortingThread extends Thread {

    private static final int MOVING_AVERAGE_SIZE = 2001;

    static int[][] randomArrays;
    static SortingGraph graph;

    SortingFunction sorter;
    double[] times;
    double[] movingAverages;
    double[] iterations;

    SortingThread(SortingFunction sorter, String name) {
        super(name);
        this.sorter = sorter;
    }

    @Override
    public void run() {
        for (int i = 0; i < times.length; i++) {
            int[] arr = Arrays.copyOf(randomArrays[i], randomArrays[i].length);
            long startTime = System.nanoTime();
            iterations[i] = sorter.sort(arr);
            double elapsedTime = (System.nanoTime() - startTime) / 1e9;
            times[i] = elapsedTime;
            if (i == MOVING_AVERAGE_SIZE - 1) {
                for (int j = 0; j < MOVING_AVERAGE_SIZE; j++) {
                    movingAverages[i / 2] += times[j];
                }
                movingAverages[i / 2] /= MOVING_AVERAGE_SIZE;
            } else if (i > MOVING_AVERAGE_SIZE - 1) {
                int j = i - MOVING_AVERAGE_SIZE / 2;
                movingAverages[j] = movingAverages[j - 1] * MOVING_AVERAGE_SIZE + times[i] - times[i - MOVING_AVERAGE_SIZE];
                movingAverages[j] /= MOVING_AVERAGE_SIZE;
            }
            graph.repaint();
        }
        System.out.format("%s: I finished!%n", Thread.currentThread().getName());
    }

    interface SortingFunction {

        int sort(int[] arr);
    }
}
