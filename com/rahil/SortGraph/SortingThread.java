package com.rahil.SortGraph;

import javax.swing.*;
import java.util.Arrays;

class SortingThread extends Thread {

    private static final int MOVING_AVERAGE_SIZE = 2001;

    static int[][] randomArrays;

    SortingFunction sorter;
    double[] times;
    double[] movingAverages;
    double[] iterations;
    JPanel panel;

    SortingThread(SortingFunction sorter, String name, double[] times, double[] movingAverages, double[] iterations, JPanel panel) {
        super(name);
        this.sorter = sorter;
        this.times = times;
        this.movingAverages = movingAverages;
        this.iterations = iterations;
        this.panel = panel;
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
            panel.repaint();
        }
        System.out.format("%s: I finished!%n", Thread.currentThread().getName());
    }

    interface SortingFunction {

        int sort(int[] arr);
    }
}
