public class Main {
    public static void main(String[] args) {
        IQueue<String> queue = new ArrayQueue<>(5);
        queue.offer("A");
        queue.offer("B");
        queue.offer("C");
        queue.print();

        System.out.printf("Se obtuvo %s%n", queue.poll());
        queue.offer("D");
        queue.offer("E");
        queue.offer("F");
        queue.offer("G");
        queue.print();
    }
}
