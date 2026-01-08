static void sleep(long ms) {
    try {
        Thread.sleep(ms);
    } catch (InterruptedException e) {
    }
}

void main() throws InterruptedException {
    Resource A = new Resource();
    Resource B = new Resource();

    // case with a deadlock

//    Thread t1 = new Thread(() -> {
//        synchronized (A.lock) {
//            sleep(200);
//            synchronized (B.lock) {
//                IO.println("T1 ok");
//            }
//        }
//    });
//
//    Thread t2 = new Thread(() -> {
//        synchronized (B.lock) { // ordre inverse ⇒ risque de deadlock
//            sleep(200);
//            synchronized (A.lock) {
//                IO.println("T2 ok");
//            }
//        }
//    });
//
//    t1.start();
//    t2.start();
//    t1.join(1000);
//    t2.join(1000);
//    IO.println("Si 'ok' n'apparaît pas, deadlock probable.");

    // case without deadlock
    Thread t3 = new Thread(() -> {safeOp(A,B);});
    Thread t4 = new Thread(() -> {safeOp(A,B);});
    t3.start();
    t4.start();
    t3.join(1000);
    t4.join(1000);
    IO.println("'ok' apparaît, pas deadlock.");
}


// Toujours acquérir les verrous dans le même ordre
void safeOp(Resource r1, Resource r2) {
    Object first = r1.lock.hashCode() < r2.lock.hashCode() ? r1.lock : r2.lock;
    Object second = first == r1.lock ? r2.lock : r1.lock;
    synchronized (first) {
        sleep(200);
        synchronized (second) {
            IO.println("T ok");
        }
    }
}


//void foo() {
//    // code non critique
//    synchronized (somelock) {
//        // section critique
//    }
//    // code non critique
//}
