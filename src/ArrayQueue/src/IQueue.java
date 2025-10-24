public interface IQueue<T> {

    void offer(T object);
    T poll();
    T peek();
    boolean isEmpty();
    int size();
    void clear();
    void print();
}
