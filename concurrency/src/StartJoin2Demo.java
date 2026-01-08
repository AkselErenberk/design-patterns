void main() throws InterruptedException {
    Thread t1 = new Thread(new Task("T1"));
    Thread t2 = new Thread(new Task("T2"));

    t1.start();
    t2.start();
    // On attend que les deux aient fini
    t1.join();
    t2.join();

    IO.println("Main: tout le monde a terminé.");
}