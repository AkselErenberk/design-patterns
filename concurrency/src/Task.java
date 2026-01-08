// A1. Deux threads qui travaillent en parallèle et que l'on attend (join)
public class Task implements Runnable {
    private final String name;

    Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("[" + name + "] démarre");
        try {

            Thread.sleep(500);
        } catch (InterruptedException e) {
            /* ok */
        }
        System.out.println("[" + name + "] termine");
    }
}