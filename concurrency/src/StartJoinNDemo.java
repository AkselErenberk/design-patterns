// A2. Généraliser à N threads

void main() throws InterruptedException {
    int N = 5;
    List<Thread> threads = new ArrayList<>();
    for (int i = 1; i <= N; i++) {
        Thread t = new Thread(new Task("T" + i));
        threads.add(t);
        t.start();
    }
    for (Thread t : threads) t.join();
    IO.println("Main: " + N + " threads terminés.");
}