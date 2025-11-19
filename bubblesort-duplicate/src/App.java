import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Cuantos elementos quieres agregar? > ");

        try(Scanner input = new Scanner(System.in)) {
            int size =  input.nextInt();

            Integer[] array = new Integer[size];

            for(int i = 0; i < size; i++){
                System.out.printf("%d) > ", i);
                array[i] = input.nextInt();
            }


            System.out.println(Arrays.toString(array));

            BubbleSort.sort(array);

            System.out.println(Arrays.toString(array));

            int max = array[size - 1];
            int min = array[0];

            System.out.println("max: " + max);
            System.out.println("min: " + min);
            System.out.println("diff: " + (max - min));
        }
    }
}
