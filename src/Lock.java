public interface Lock {
    void requestCS(int tid); // Request critical section
    void releaseCS(int tid); // Release critical section
} 