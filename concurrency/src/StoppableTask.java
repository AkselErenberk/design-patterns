class StoppableTask implements Runnable {
    public volatile boolean stop = false; // visible immédiatement pour les autres threads

    @Override
    public void run() {
        while (!stop) {
            // Travail simulé
            doWork();
        }
        System.out.println("[Task] arrêté proprement.");
    }

    private void doWork() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            /* ok */
        }
    }
}
