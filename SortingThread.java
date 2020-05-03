import java.util.Arrays;

/**
 * Represents a
 */
class SortingThread extends Thread {

    static int[][] randomArrays;
    static SortingGraph graph;

    SortingFunction sorter;
    double[] line;

    SortingThread(SortingFunction sorter, String name) {
        super(name);
        this.sorter = sorter;
    }

    @Override
    public void run() {
        for (int i = 0; i < SortingGraph.MAX_ARRAY_SIZE; i++) {
            int[] arr = Arrays.copyOf(randomArrays[i], randomArrays[i].length);
            long startTime = System.nanoTime();
            sorter.sort(arr);
            double elapsedTime = (System.nanoTime() - startTime) / 1e9;
            line[i] = elapsedTime;
            graph.repaint();
        }
        System.out.format("%s: I finished!%n", Thread.currentThread().getName());
    }

    interface SortingFunction {
        void sort(int[] arr);
    }
}
