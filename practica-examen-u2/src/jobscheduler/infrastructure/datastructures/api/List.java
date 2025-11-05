package jobscheduler.infrastructure.datastructures.api;

public interface List<T> extends Collection<T>{
    int size();
    boolean isEmpty();
    void addFirst(T element);
    void addLast(T element);
    T get(int index);
    T removeFirst();
    boolean remove(T element);
    void clear();
}
