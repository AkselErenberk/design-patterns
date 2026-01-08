class Wall {
    private boolean wallBuilt = false;

    public synchronized void raiseTheWall() {
        buildTheWall();
        wallBuilt = true;
        notifyAll(); // un changement d'état : on réveille les en attente
    }

    public synchronized void placeCables() throws InterruptedException {
        while (!wallBuilt) { // boucle, pas if
            wait();          // libère le verrou et s'endort
        }
        placeTheCables();
    }

    private void buildTheWall() {
        System.out.println("[Brick] construit...");
    }

    private void placeTheCables() {
        System.out.println("[Spark] câble...");
    }
}