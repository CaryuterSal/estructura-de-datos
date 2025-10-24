public class ArrayQueue<T> implements IQueue<T>{

    private T[] data;
    private int rear;
    private int front;
    private int size;

    @SuppressWarnings("unchecked")
    public ArrayQueue(int initialCapacity) {
        data = (T[]) new Object[5];
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

    @Override
    public void clear() {

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
