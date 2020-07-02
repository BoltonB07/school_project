package com.rahil.SortGraph;

import java.util.Arrays;

class SortTest {

    private static final Sorter[] SORTING_FUNCTIONS = new Sorter[]{
            Sort :: Bubble,
            Sort :: Insertion,
            Sort :: Selection,
            Sort :: Merge,
            Sort :: Quick
    };

    private static final String[] NAMES = new String[]{
            "Bubble sort",
            "Insertion sort",
            "Selection sort",
            "Merge sort",
            "Quick sort"
    };

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; ++i) {
            arr[i] = (int) (Math.random() * 1000);
        }
        int[] sorted = Arrays.copyOf(arr, 1000);
        Arrays.sort(sorted);
        for (int i = 0; i < SORTING_FUNCTIONS.length; i++) {
            int[] copy = Arrays.copyOf(arr, 1000);
            SORTING_FUNCTIONS[i].sort(copy);
            if (Arrays.equals(copy, sorted)) {
                System.out.format("%s passed%n", NAMES[i]);
            } else {
                System.out.format("%s failed%n", NAMES[i]);
            }
        }
    }

    interface Sorter {

        int sort(int[] arr);
    }
}
