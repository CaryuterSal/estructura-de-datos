import java.util.Comparator;

public class SelectionSort {

    public static <T extends Comparable<T>> void sort(T[] array) {
        sort(array, Comparator.naturalOrder());
    }

    public static <T> void sort(T[] array, Comparator<T> comparator) {
        sortAndSyc(array, comparator, new Object[array.length]);
    }

    public static <T extends Comparable<T>> void sortAndSync(T[] array, Object[] other) {
        sortAndSyc(array, Comparator.naturalOrder(), other);
    }

    public static <T> void sortAndSyc(T[] array, Comparator<T> comparator, Object[] other) {
        if(array.length != other.length) {
            throw new IllegalArgumentException("Arrays to sort must be same length");
        }
        int minIndex = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++){
                if(comparator.compare(array[minIndex],array[j]) > 0){
                    minIndex = j;
                }
            }
            T temp = array[minIndex];
            Object otherTemp = other[minIndex];
            array[minIndex] = array[i];
            other[minIndex] = other[i];
            array[i] = temp;
            other[i] = otherTemp;
        }
    }
}
