public interface Lock {
    void requestCS(int i); // Request critical section
    void releaseCS(int i); // Release critical section
} 