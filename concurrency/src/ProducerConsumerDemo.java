void main() {
    BoundedQueue<Integer> buf = new BoundedQueue<>(5);

    Thread producer = new Thread(() -> {
        for (int i = 0; i < 20; i++) {
            try {
                buf.put(i);
                IO.println("Prod → " + i);
                Thread.sleep(100);
            } catch (InterruptedException e) { /* ok */ }
        }
    });

    Thread consumer = new Thread(() -> {
        for (int i = 0; i < 20; i++) {
            try {
                int v = buf.take();
                IO.println("    Cons ← " + v);
                Thread.sleep(150);
            } catch (InterruptedException e) { /* ok */ }
        }
    });

    producer.start();
    consumer.start();
    try {
        producer.join();
        consumer.join();
    } catch (InterruptedException ignored) {
    }
    IO.println("Terminé.");
}
