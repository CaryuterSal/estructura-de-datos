public class InsertionSort {
    public static void sort(double[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            double actualValue = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > actualValue) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = actualValue;
        }
    }
}
