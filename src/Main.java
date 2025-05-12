import java.util.Scanner;

public class Main {
    private static int[] arr;
    private static volatile int shared_max;
    private static volatile int shared_min;
    private static Dekker lock;
    private static int n; // Array size

    static class MaxMinThread extends Thread {
        private Lock lock;
        private int tid;
        private int start;
        private int end;

        public MaxMinThread(Lock lock, int tid, int start, int end) {
            this.lock = lock;
            this.tid = tid;
            this.start = start;
            this.end = end;
        }

        // Critical section - must be executed atomically
        private void CS(int localMax, int localMin) {
            // Update shared values atomically
            if (localMax > shared_max) {
                shared_max = localMax;
            }
            if (localMin < shared_min) {
                shared_min = localMin;
            }
        }

        @Override
        public void run() {
            // Find local max and min in the assigned portion
            int localMax = arr[start];
            int localMin = arr[start];
            
            // Process elements in chunk
            for (int i = start + 1; i < end; i++) {
                if (arr[i] > localMax) localMax = arr[i];
                if (arr[i] < localMin) localMin = arr[i];
            }

            // Enter critical section to update shared values
            lock.requestCS(tid);
            try {
                CS(localMax, localMin);
            } finally {
                lock.releaseCS(tid);
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
        scanner.close();

        // Initialize lock and shared variables
        lock = new Dekker();
        shared_max = Integer.MIN_VALUE;
        shared_min = Integer.MAX_VALUE;

        // Create and start two threads
        Thread[] threads = new Thread[2];
        int mid = n / 2;

        // First thread processes first half
        threads[0] = new MaxMinThread(lock, 0, 0, mid);
        // Second thread processes second half
        threads[1] = new MaxMinThread(lock, 1, mid, n);

        // Start both threads
        threads[0].start();
        threads[1].start();

        // Wait for both threads to complete
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Print final results
        System.out.println("Gia tri lon nhat: " + shared_max);
        System.out.println("Gia tri nho nhat: " + shared_min);
    }
}