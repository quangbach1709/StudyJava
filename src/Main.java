import java.util.Scanner;

public class Main {
    private static int[] arr;
    private static int shared_max;
    private static int shared_min;
    private static Bakery lock;
    private static int n; // Array size
    private static int k; // Number of threads

    static class MaxMinThread extends Thread {
        private int threadId;
        private int start;
        private int end;

        public MaxMinThread(int threadId, int start, int end) {
            this.threadId = threadId;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            // Find local max and min in the assigned portion
            int localMax = Integer.MIN_VALUE;
            int localMin = Integer.MAX_VALUE;
            
            // Only process if start is within array bounds
            if (start < arr.length) {
                localMax = arr[start];
                localMin = arr[start];
                
                // Process remaining elements in chunk
                for (int i = start + 1; i < end && i < arr.length; i++) {
                    if (arr[i] > localMax) localMax = arr[i];
                    if (arr[i] < localMin) localMin = arr[i];
                }
            }

            // Critical section: Update shared max and min
            lock.requestCS(threadId);
            try {
                if (localMax > shared_max) shared_max = localMax;
                if (localMin < shared_min) shared_min = localMin;
            } finally {
                lock.releaseCS(threadId);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        n = scanner.nextInt();
        arr = new int[n];
        
        // Input array elements
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Input number of threads
        k = scanner.nextInt();
        scanner.close();

        // Ensure k doesn't exceed array size
        k = Math.min(k, n);

        // Initialize lock and shared variables
        lock = new Bakery(k);
        shared_max = Integer.MIN_VALUE;
        shared_min = Integer.MAX_VALUE;

        // Create and start threads
        Thread[] threads = new Thread[k];
        int chunkSize = (int) Math.ceil((double) n / k); // Proper ceiling division

        for (int i = 0; i < k; i++) {
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, n); // Ensure end doesn't exceed array length
            threads[i] = new MaxMinThread(i, start, end);
            threads[i].start();
        }

        // Wait for all threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print results
        System.out.println("Gia tri lon nhat: " + shared_max);
        System.out.println("Gia tri nho nhat: " + shared_min);
    }
}