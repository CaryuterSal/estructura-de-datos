import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("¿Cuántas temperaturas deseas ingresar?: ");
        int n = sc.nextInt();

        double[] temperaturas = new double[n];

        System.out.println("Ingresa las " + n + " temperaturas:");
        for (int i = 0; i < n; i++) {
            temperaturas[i] = sc.nextDouble();
        }
        
        double[] original = new double[n];
        for (int i = 0; i < n; i++) {
            original[i] = temperaturas[i];
        }

        InsertionSort.sort(temperaturas);

        double min = temperaturas[0];
        double max = temperaturas[n - 1];
        double range = max - min;

        int lowQuantities = n >= 3 ? 3 : n;
        double[] lows = new double[lowQuantities];
        for (int i = 0; i < lowQuantities; i++) {
            lows[i] = temperaturas[i];
        }

        int highQuantities = n >= 3 ? 3 : n;
        double[] highs = new double[highQuantities];
        int index = 0;
        for (int i = n - highQuantities; i < n; i++) {
            highs[index++] = temperaturas[i];
        }

        System.out.println("\n--- Arreglo original ---");
        imprimir(original);

        System.out.println("\n--- Arreglo ordenado (menor a mayor) ---");
        imprimir(temperaturas);

        System.out.println("\n--- Resultados ---");
        System.out.println("Temperatura mínima: " + min);
        System.out.println("Temperatura máxima: " + max);
        System.out.println("Rango (máx - mín): " + range);

        System.out.println("\nLas 3 temperaturas más bajas:");
        imprimir(lows);

        System.out.println("Las 3 temperaturas más altas:");
        imprimir(highs);

        sc.close();
    }

    public static void imprimir(double[] arr) {
        for (double t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }
}
