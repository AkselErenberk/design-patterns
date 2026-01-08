void main() throws InterruptedException {
    Account a = new Account();

    Runnable r1 = () -> {
        a.retraitUnsafe(800);
    };
    Runnable r2 = () -> {
        a.retraitUnsafe(700);
    };

    Thread t1 = new Thread(r1);
    Thread t2 = new Thread(r2);
    t1.start();
    t2.start();
    t1.join();
    t2.join();
    IO.println("Solde (unsafe) = " + a.getSolde());

    // Recommence avec la version safe
    Account b = new Account();
    Thread s1 = new Thread(() -> b.retraitSafe(800));
    Thread s2 = new Thread(() -> b.retraitSafe(700));
    s1.start();
    s2.start();
    s1.join();
    s2.join();
    IO.println("Solde (safe) = " + b.getSolde());
}