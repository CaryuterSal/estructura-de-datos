package jobscheduler.infrastructure.datastructures;


import jobscheduler.infrastructure.datastructures.api.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayQueue<T> implements Queue<T> {

    private T[] data;
    private int rear;
    private int front;
    private int size;

    public ArrayQueue() {
        this(5);
    }
    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity(){
        T[] newArr = (T[]) new Object[data.length*2];
        for(int i = 0; i < size; i++){
            newArr[i] = data[(front + i) % data.length];
        }

        front = 0;
        rear = size;
        data = newArr;
    }

    @Override
    public void offer(T element) {
        if(isFull()) expandCapacity();
        data[rear] = element;
        rear = (rear + 1) % data.length;
        size++;
    }

    @Override
    public T poll() {
        if(isEmpty()){
            return null;
        }
        T result = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if(isEmpty()){
            return null;
        }
        return data[front];
    }

    @Override
    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull(){
        return  size == data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        data = (T[]) new Object[5];
        front = 0;
        rear = 0;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int current = front;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                T value = data[current];
                current = (current + 1) % data.length;
                count++;
                return value;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < size; i++){
            sb.append(data[(front+i) % data.length].toString());
            if(i !=size - 1)sb.append("->");
        }

        sb.append("]");
        return sb.toString();
    }
}
