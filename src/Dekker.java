public class Dekker implements Lock {
    private int turn; // Whose turn to enter critical section
    private boolean[] wantCS; // Array indicating if thread wants to enter CS

    public Dekker() {
        turn = 0;
        wantCS = new boolean[2];
        wantCS[0] = false;
        wantCS[1] = false;
    }

    @Override
    public void requestCS(int i) {
        int j = 1 - i; // Other thread's index
        
        // Indicate that this thread wants to enter CS
        wantCS[i] = true;
        
        // Wait while other thread wants to enter CS
        while (wantCS[j]) {
            if (turn == j) {
                // If it's other thread's turn, give up and wait
                wantCS[i] = false;
                while (turn == j) {
                    Thread.yield(); // Give up CPU time
                }
                wantCS[i] = true;
            }
        }
    }

    @Override
    public void releaseCS(int i) {
        turn = 1 - i; // Give turn to other thread
        wantCS[i] = false; // Indicate this thread is done with CS
    }
} 