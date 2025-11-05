package jobscheduler.infrastructure.datastructures;

import jobscheduler.infrastructure.datastructures.api.Stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayStack<T> implements Stack<T> {

    private T[] data;
    private int top;
    private int size;

    public ArrayStack() {
        this(5);
    }

    @SuppressWarnings("unchecked")
    public ArrayStack(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
        top = 0;
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void expandCapacity() {
        T[] newArr = (T[]) new Object[data.length * 2];
        int bottom = (top - size) % data.length;
        if (bottom < 0) bottom += data.length;

        for (int i = 0; i < size; i++) {
            newArr[i] = data[(bottom + i) % data.length];
        }
        top = size;
        data = newArr;
    }

    @Override
    public void push(T element) {
        if (isFull()) expandCapacity();
        data[top] = element;
        top = (top + 1) % data.length;
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) return null;
        top = (top - 1) % data.length;
        if (top < 0) top += data.length;
        T result = data[top];
        data[top] = null;
        size--;
        return result;
    }

    @Override
    public T peek() {
        if (isEmpty()) return null;
        int idx = (top - 1) % data.length;
        if (idx < 0) idx += data.length;
        return data[idx];
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public int size() {
        return size;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        data = (T[]) new Object[5];
        top = 0;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count = 0;
            private int current = (top - 1 + data.length) % data.length;

            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                T v = data[current];
                current = (current - 1 + data.length) % data.length;
                count++;
                return v;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        int bottom = (top - size) % data.length;
        if (bottom < 0) bottom += data.length;

        for (int i = 0; i < size; i++) {
            T elem = data[(bottom + i) % data.length];
            sb.append(elem == null ? "null" : elem.toString());
            if (i != size - 1) sb.append("->");
        }
        sb.append("]");
        return sb.toString();
    }
}
