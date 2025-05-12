public class Bakery implements Lock {
    private int n; // Number of threads
    private boolean[] choosing; // Array to indicate if thread is choosing a number
    private int[] number; // Array to store ticket numbers

    public Bakery(int n) {
        this.n = n;
        choosing = new boolean[n];
        number = new int[n];
        for (int i = 0; i < n; i++) {
            choosing[i] = false;
            number[i] = 0;
        }
    }

    @Override
    public void requestCS(int i) {
        // Step 1: Choose a number
        choosing[i] = true;
        // Find maximum number and add 1
        int max = 0;
        for (int j = 0; j < n; j++) {
            if (number[j] > max) {
                max = number[j];
            }
        }
        number[i] = max + 1;
        choosing[i] = false;

        // Step 2: Wait for turn
        for (int j = 0; j < n; j++) {
            // Wait while thread j is choosing
            while (choosing[j]) {
                Thread.yield();
            }
            // Wait while thread j has a lower number or same number but higher priority
            while ((number[j] != 0) && 
                   ((number[j] < number[i]) || 
                    (number[j] == number[i] && j < i))) {
                Thread.yield();
            }
        }
    }

    @Override
    public void releaseCS(int i) {
        number[i] = 0; // Release the lock by setting number to 0
    }
} 