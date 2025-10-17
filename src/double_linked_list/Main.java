package double_linked_list;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("IMPRIME LA LISTA COMPLETA ------------------------");
        DoubleLinkedList<Integer> list = new DoubleLinkedList<>(List.of(2,4,5,7,10));
        list.printForwards();
        list.printBackwards();

        System.out.println("IMPRIME LA LISTA ELIMINANDO INDEX 2 ---------------------");

        list.remove(Integer.valueOf(2));
        list.printForwards();
        list.printBackwards();


        System.out.println("IMPRIME LA LISTA AÑADIENDO UN ELEMENTO AL FINAL ---------------------");

        list.add(22);
        list.printForwards();
        list.printBackwards();


        System.out.println("ELIMINA AL INICIO DE LA LISTA -----------------------");
        list.remove(Integer.valueOf(0));
        list.printForwards();
        list.printBackwards();

        System.out.println("ELIMINA AL FINAL DE LA LISTA -------------------------");
        list.remove(3);
        list.printForwards();
        list.printBackwards();

    }
}
