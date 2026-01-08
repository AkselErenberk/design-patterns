void main() throws InterruptedException {
    StoppableTask task = new StoppableTask();
    Thread t = new Thread(task);
    t.start();

    Thread.sleep(1000);     // le laisse travailler un peu
    task.stop = true;       // demande d'arrêt
    t.join();               // on attend
    IO.println("Main: fini.");
}