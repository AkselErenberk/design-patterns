void main() throws InterruptedException {
    Wall w = new Wall();
    Thread spark = new Thread(() -> {
        try {
            w.placeCables();
        } catch (InterruptedException e) { /* ok */ }
    });
    Thread brick = new Thread(w::raiseTheWall);

    spark.start();
    Thread.sleep(300);
    brick.start();

    spark.join();
    brick.join();
    IO.println("Coordination OK.");
}