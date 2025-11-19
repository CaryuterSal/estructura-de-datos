import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingresa la cantidad de números: ");
        int n = sc.nextInt();

        int[] originals = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.printf("%d ) > ", i);
            originals[i] = sc.nextInt();
        }

        int evenCount = 0;
        int oddCount = 0;

        for (int num : originals) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        int[] even = new int[evenCount];
        int[] odd = new int[oddCount];

        int pIndex = 0;
        int iIndex = 0;

        for (int num : originals) {
            if (num % 2 == 0) {
                even[pIndex++] = num;
            } else {
                odd[iIndex++] = num;
            }
        }

        SelectionSort.sort(even);
        SelectionSort.sort(odd);

        System.out.println("\n--- Arreglo original ---");
        imprimir(originals);

        System.out.println("--- Números pares ordenados (ascendente) ---");
        imprimir(even);

        System.out.println("--- Números impares ordenados (ascendente) ---");
        imprimir(odd);

        sc.close();
    }

    public static void imprimir(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
