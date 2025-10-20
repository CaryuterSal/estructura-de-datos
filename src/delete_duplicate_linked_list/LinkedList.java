package delete_duplicate_linked_list;

import linked_list.Node;

import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {

    private Node<T> head;
    public boolean add(T data){
        linked_list.Node<T> node = new linked_list.Node<>(data);
        if(head == null){
            head = node;
            return true;
        }
        linked_list.Node<T> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(node);
        return true;
    }

    public boolean removeDuplicates(){
        Node<T> current = head;
        boolean result = false;
        while(current != null){
            result = removeDuplicate(current);
            current = current.getNext();
        }
        return result;
    }

    private boolean removeDuplicate(Node<T> nodeToCompare){
        if(nodeToCompare == null) return false;
        Node<T> current = nodeToCompare;
        T data = nodeToCompare.getData();

        boolean result = false;
        while(current.getNext()!= null){
            if(current.getNext().getData().equals(data)){
                current.setNext(current.getNext().getNext());
                result = true;
            } else {
                current = current.getNext();
            }
        }
        return result;
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
                T data = current.getData();
                current = current.getNext();
                return data;
            }
        };
    }
}
