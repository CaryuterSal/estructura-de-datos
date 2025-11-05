package jobscheduler.infrastructure.datastructures.api;

public interface Queue<T> extends Collection<T>{
    void offer(T object);
    T poll();
    T peek();
    boolean isEmpty();
    int size();
    void clear();
    void print();
}
