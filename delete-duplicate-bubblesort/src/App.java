import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        Integer[] array = {5,1,7,5,1,12,3,2,12,6};
        System.out.printf("No Ordenado: %s%n", Arrays.toString(array));
        BubbleSort.sort(array);
        System.out.printf("Ordenado: %s%n", Arrays.toString(array));
        System.out.printf("Eliminado duplicado: %s%n", Arrays.toString(
                DuplicatesFilter.removeDuplicatesFromOrdered(array)));
    }
}
