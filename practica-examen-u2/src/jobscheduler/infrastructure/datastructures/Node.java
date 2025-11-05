package jobscheduler.infrastructure.datastructures;

import java.util.Objects;

public class Node<T> {
    private final T data;
    private Node<T> next;

    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public T data() {
        return data;
    }

    public Node<T> next() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;
        return Objects.equals(data, node.data) && Objects.equals(next, node.next);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(data);
        result = 31 * result + Objects.hashCode(next);
        return result;
    }
}
