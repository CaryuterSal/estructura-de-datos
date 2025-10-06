package generics;

public class Main {

    public static <T> void printArray(T[] array){
        for(T element : array){
            System.out.println(element);
        }
    }

    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Esta es una caja de strings");
        System.out.println(box1.getValue());

        Box<String> box2 = new Box<>("Esta es otra caja de strings");
        Box<String> box3 = new Box<>("Esta es una caja de strings no vacía");
        printArray(new String[]{box1.getValue(), box2.getValue(), box3.getValue()});

        Box<Integer> integerBox = new Box<>(43);

        System.out.printf("El valor de la caja es %d%n", integerBox.getValue());
    }
}
