package linked_list;

public class Main {

    private static final DynamicLinkedList<String> messages = new DynamicLinkedList<>();

    public static void main(String[] args) {
        messages.add("Hello");
        messages.add("World");
        messages.add("From");
        messages.add("Linked");
        messages.add("List");
        messages.add("Hello");
        messages.add("World");
        messages.add("Hello");

        for(String message : messages){
            System.out.println(message);
        }

        System.out.println("La lista es: ");
        System.out.println(messages);
        System.out.printf("La cuenta de \"Hello\" en la lista es: %d%n", messages.countContaining("Hello"));
        System.out.printf("Hay %d elementos en la lista%n", messages.size());
    }
}
