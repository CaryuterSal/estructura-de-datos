package linked_list;

import java.util.Objects;
import java.util.function.Consumer;

public class Node<T> {
    private T data;
    private Node<T> next;

    public Node<T> getNext() {
        return next;
    }


    public Node(T data) {
        this.data = data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public boolean hasNext() {
        return next != null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Node<?> node = (Node<?>) o;
        return Objects.equals(getData(),node.getData());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getData());
    }
}
