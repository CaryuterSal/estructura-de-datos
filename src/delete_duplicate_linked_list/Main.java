package delete_duplicate_linked_list;

public class Main {
    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(10);
        list.add(10);
        list.add(10);

        list.removeDuplicates();

        list.forEach(System.out::println);

    }
}
