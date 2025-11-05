package jobscheduler.infrastructure.datastructures.api;

public interface Stack<T> extends Collection<T>{
    void push(T element);
    T pop();
    T peek();
    boolean isEmpty();
    int size();
    void clear();
}
