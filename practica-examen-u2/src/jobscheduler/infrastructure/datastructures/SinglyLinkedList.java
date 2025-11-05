package jobscheduler.infrastructure.datastructures;

import jobscheduler.infrastructure.datastructures.api.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SinglyLinkedList<T> implements List<T> {

    private Node<T> head;
    private int size;

    public SinglyLinkedList() {}

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public void addFirst(T element){
        Node<T> newNode = new Node<>(element);
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    @Override
    public void addLast(T element){
        Node<T> newNode = new Node<>(element);
        if(isEmpty()){
            head = newNode;
        } else {
            Node<T> current = head;
            while(current.next() != null){
                current = current.next();
            }
            current.setNext(newNode);
        }
        size++;
    }

    @Override
    public T get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> current = head;
        int count = 0;
        while(count < index){
            current = current.next();
            count++;
        }
        return current.data();
    }

    @Override
    public T removeFirst(){
        if(isEmpty()) return null;

        T value = head.data();
        head = head.next();
        size--;
        return value;
    }

    @Override
    public boolean remove(T element){
        if(isEmpty()) return false;

        if(head.data().equals(element)){
            head = head.next();
            size--;
            return true;
        }

        Node<T> current = head;
        while(current.next() != null){
            if(current.next().data().equals(element)){
                current.setNext(current.next().next());
                size--;
                return true;
            }
            current = current.next();
        }
        return false;
    }

    @Override
    public void clear(){
        head = null;
        size = 0;
    }

    public void print(){
        System.out.println(this.toString());
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(current == null) throw new NoSuchElementException();
                T val = current.data();
                current = current.next();
                return val;
            }
        };
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> current = head;
        while(current != null){
            sb.append(current.data());
            if(current.next() != null) sb.append(" -> ");
            current = current.next();
        }
        sb.append("]");
        return sb.toString();
    }

}
