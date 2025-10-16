package linked_list;

import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class DynamicLinkedList<T> implements Iterable<T>, List<T>, Cloneable, Serializable {

    private Node<T> head;

    public boolean add(T data){
        Node<T> node = new Node<>(data);
        if(head == null){
            head = node;
            return true;
        }
        Node<T> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(node);
        return true;
    }

    @Override
    public boolean remove(Object o) {

        if(head != null && head.getData().equals(o)){
            head = head.getNext();
            return true;
        }

        Node<T> current = head;
        while(current.getNext() != null){
            if(current.getNext().getData().equals(o)){
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        Node<T> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        for(T data : c){
            Node<T> node = new Node<>(data);
            current.setNext(node);
            current = node;
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        head = null;
    }

    private Node<T> getNode(int index){

        Node<T> current = head;
        for(int i = 0; i < index; i++){
            if(current.getNext() == null){
                throw new IndexOutOfBoundsException();
            }
            current = current.getNext();
        }
        return current;
    }

    @Override
    public T get(int index) {
        return getNode(index).getData();
    }

    @Override
    public T set(int index, T element) {
        getNode(index).setData(element);
        return element;
    }

    @Override
    public void add(int index, T element) {
        Node<T> nodeAtIndex = getNode(index);
        Node<T> newNode = new Node<>(element);
        nodeAtIndex.setNext(newNode);
    }

    @Override
    public T remove(int index) {
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException();
        }
        if(index == 0){
            Node<T> nodeToRemove = head;
            head = head.getNext();
            return nodeToRemove.getData();
        }
        Node<T> previousNode = getNode(index - 1);
        Node<T> nodeToRemove =  previousNode.getNext();
        previousNode.setNext(nodeToRemove.getNext());
        return nodeToRemove.getData();
    }

    @Override
    public int indexOf(Object o) {
        if(head == null){
            return -1;
        }
        Node<T> current = head;
        int index = 0;
        while(current != null){
            if(current.getData().equals(o)) return index;
            current = current.getNext();
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return List.of();
    }


    @Override
    public int size() {
        int accum = 0;
        Node<T> current = head;
        while(current != null){
            accum++;
            current=current.getNext();
        }
        return accum;
    }

    @Override
    public boolean isEmpty() {
        return head != null;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    public int countContaining(T data){
        int count = 0;
        Node<T> current = head;
        while(current != null){
            if(current.getData().equals(data)){
                count++;
            }
            current = current.getNext();
        }
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T value = current.getData();
                current = current.getNext();
                return value;
            }
        };
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("[ ");

        Node<T> current = head;
        while(current != null){
            string.append(current.getData());
            if(current.getNext() != null){
                string.append(", ");
            }
            current = current.getNext();
        }

        string.append(" ]");
        return string.toString();

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        DynamicLinkedList<?> that = (DynamicLinkedList<?>) o;

        try {
            for (int i = 0; i < this.size(); i++) {
                if (!that.get(i).equals(this.get(i))) return false;
            }
        } catch (IndexOutOfBoundsException e) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for(T node: this){
            hashCode = 31 * hashCode + node.hashCode();
        }
        return hashCode;
    }

    @SuppressWarnings("unchecked")
    @Override
    protected Object clone() throws CloneNotSupportedException {

        DynamicLinkedList<T> list = (DynamicLinkedList<T>) super.clone();;
        return list.addAll(this);
    }
}
