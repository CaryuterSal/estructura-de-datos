import java.util.Arrays;
import java.util.Comparator;
import java.util.SortedSet;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T>{

    @Override
    public T[] sort(T[] arr) {
        int a = arr.length;
        T[] arrCopy = Arrays.copyOf(arr, a);
        for(int i = 0; i < a - 1; i++){
            for (int j = 0; j < a - 1 - i; j++) {
                if(arrCopy[j].compareTo(arrCopy[j + 1]) > 0){
                    T temp = arrCopy[j];
                    arrCopy[j] = arrCopy[j+1];
                    arrCopy[j+1] = temp;
                }
            }
        }
        return arrCopy;
    }
}
