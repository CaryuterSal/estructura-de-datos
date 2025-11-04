import java.util.Iterator;

public class ArrayQueue<T> implements Queue<T>{

    private T[] data;
    private int rear;
    private int front;
    private int size;

    public ArrayQueue(){
        this(5);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        data = (T[]) new Object[initialCapacity];
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(ArrayQueue<T> queue) {
        data = (T[]) new Object[queue.size()];
        rear = queue.rear;
        front = queue.front;
        size = queue.size;
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
        size = 0;
        front = 0;
        rear = 0;
    }

    @Override
    public void reverse() {
        if(size <= 1) return;
        reverse(0, size - 1);
    }

    private void reverse(int i, int j) {
        if(i >= j) return;

        int leftIndex = (front + i) % data.length;
        int rightIndex = (front + j) % data.length;

        T temp = data[leftIndex];
        data[leftIndex] = data[rightIndex];
        data[rightIndex] = temp;

        reverse(i + 1, j - 1);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }
            @Override
            public T next() {
                T result = data[index];
                index = (index + 1) % data.length;
                return result;
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
