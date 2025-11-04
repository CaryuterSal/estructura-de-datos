public interface Queue<T> extends Iterable<T>{
//dfg
    void offer(T object);
    T poll();
    T peek();
    boolean isEmpty();
    int size();
    void clear();
    void print();
    void reverse();
}
