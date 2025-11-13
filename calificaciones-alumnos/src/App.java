import java.util.Comparator;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)) {
            System.out.println("¿Cuántas calificaciones vas a ingresar?");
            int quantity = sc.nextInt();


            Double[] grades = new Double[quantity];
            String[] names = new String[quantity];

            for(int i = 0; i < quantity; i++) {
                System.out.printf("Nombre %d%n", i + 1);
                names[i] = sc.next();
                System.out.printf("Calificación %d%n", i + 1);
                grades[i] = sc.nextDouble();
            }

            SelectionSort.sortAndSync(grades, names);
            System.out.println("Calificaciones ordenadas ------------");
            for(int i = 0; i < quantity; i++) {
                System.out.printf("%s - %.2f%n", names[i], grades[i]);
            }
        }
    }
}
