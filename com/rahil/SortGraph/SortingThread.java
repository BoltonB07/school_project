package com.rahil.SortGraph;

import javax.swing.*;
import java.util.Arrays;

class SortingThread extends Thread {

    private static final int MOVING_AVERAGE_SIZE = 2001;

    SortingFunction sorter;
    JPanel panel;
    int[][] unsortedArrays;
    double[] times;
    double[] iterations;
    double[] timeMovingAverages;

    SortingThread(String name, SortingFunction sorter, JPanel panel, int[][] unsortedArrays) {
        super(name);
        this.sorter = sorter;
        this.panel = panel;
        this.unsortedArrays = unsortedArrays;
        this.times = new double[unsortedArrays.length];
        this.iterations = new double[unsortedArrays.length];
        timeMovingAverages = new double[unsortedArrays.length];
    }

    @Override
    public void run() {
        for (int i = 0; i < times.length; i++) {
            int[] arr = Arrays.copyOf(unsortedArrays[i], unsortedArrays[i].length);
            long startTime = System.nanoTime();
            iterations[i] = sorter.sort(arr);
            double elapsedTime = (System.nanoTime() - startTime) / 1e9;
            times[i] = elapsedTime;

            // Computes moving average
            if (i == MOVING_AVERAGE_SIZE - 1) {
                for (int j = 0; j < MOVING_AVERAGE_SIZE; j++) {
                    timeMovingAverages[i / 2] += times[j];
                }
                timeMovingAverages[i / 2] /= MOVING_AVERAGE_SIZE;
            } else if (i > MOVING_AVERAGE_SIZE - 1) {
                int j = i - MOVING_AVERAGE_SIZE / 2;
                timeMovingAverages[j] =
                        timeMovingAverages[j - 1] * MOVING_AVERAGE_SIZE + times[i] - times[i - MOVING_AVERAGE_SIZE];
                timeMovingAverages[j] /= MOVING_AVERAGE_SIZE;
            }

            panel.repaint();
        }
        System.out.format("%s: Finished%n", Thread.currentThread().getName());
    }

    interface SortingFunction {

        int sort(int[] arr);
    }
}
