package double_linked_list;

import java.util.Collection;
import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {


    Node<T> head;

    public DoubleLinkedList(Collection<T> source) {
        for(T item : source) {
            add(item);
        }
    }

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node<T> current = head;
        while(current.next() != null){
            current = current.next();
        }
        current.setNext(newNode);
        newNode.setPrev(current);
    }

    public void remove(int index){
        Node<T> current = head;
        if(index < 0) throw new IndexOutOfBoundsException();
        for(int i = 0; i < index; i++){
            if(current.next() == null)
                throw new IndexOutOfBoundsException();
            current = current.next();
        }
        remove(current);
    }

    public boolean remove(T data){
        Node<T> current = head;
        while(current != null){
            if(current.data().equals(data)){
                remove(current);
                return true;
            }
            current = current.next();
        }
        return false;
    }

    private void remove(Node<T> current){
        if(current == null) return;
        Node<T> prev = current.prev();
        Node<T> next = current.next();

        if(prev == null){
            head = head.next();
            head.setPrev(null);
            return;
        }
        if(next == null){
            prev.setNext(null);
            return;
        }
        prev.setNext(next);
        next.setPrev(prev);
    }

    public void printForwards(){
        System.out.print("\n[ ");
        for(T data: this){
            System.out.print(data + ", ");
        }
        System.out.print("\b\b \b");
        System.out.println(" ]");
    }

    public void printBackwards(){
        System.out.print("\n[ ");
        for (Iterator<T> it = backwardsIterator(); it.hasNext(); ) {
            T data = it.next();
            System.out.print(data + ", ");
        }
        System.out.print("\b\b \b");
        System.out.println(" ]");
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
                T data = current.data();
                current = current.next();
                return data;
            }
        };
    }

    public Iterator<T> backwardsIterator(){
        return new Iterator<T>() {

            Node<T> current;

            {
                Node<T> lastNode = head;
                while(lastNode.next() != null){
                    lastNode = lastNode.next();
                }
                current = lastNode;
            }

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {

                T data = current.data();
                current = current.prev();
                return data;
            }
        };
    }
}
