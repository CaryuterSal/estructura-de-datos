public class Main {
    public static void main(String[] args) {

        Queue<Customer> customerQueue = new ArrayQueue<>();
        customerQueue.offer(new Customer("John"));
        customerQueue.offer(new Customer("Jane"));
        customerQueue.offer(new Customer("Mary"));
        customerQueue.offer(new Customer("Joe"));
        customerQueue.offer(new Customer("Andrew"));
        customerQueue.offer(new Customer("Michael"));

        System.out.println(customerQueue);
        customerQueue.reverse();

        System.out.println("REVERSED:");
        System.out.println(customerQueue);
    }
}
