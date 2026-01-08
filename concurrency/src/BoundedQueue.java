import java.util.LinkedList;
import java.util.Queue;

class BoundedQueue<T> {
    private final int capacity;
    private final Queue<T> q = new LinkedList<>();

    BoundedQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void put(T item) throws InterruptedException {
        while (q.size() == capacity) wait();
        q.add(item);
        notifyAll();
    }

    public synchronized T take() throws InterruptedException {
        while (q.isEmpty()) wait();
        T item = q.remove();
        notifyAll();
        return item;
    }
}