
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        LinkedList<Integer> evenList = new LinkedList<>();
        LinkedList<Integer> oddList = new LinkedList<>();
        LinkedListUtils.splitEvenOdd(list, evenList, oddList);
        System.out.println("EVEN: ");
        System.out.println(evenList);
        System.out.println("ODD: ");
        System.out.println(oddList);
    }
}
