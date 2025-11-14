import java.util.Arrays;

public class DuplicatesFilter {
    @SuppressWarnings("unchecked")
    public static <T extends Comparable<T>> T[] removeDuplicatesFromOrdered(T[] array){
        T[] endArray = (T[]) new Comparable[array.length];


        int count = 0;
        T current = array[0];
        endArray[0] = current;
        for(int i = 0; i < array.length; i++){
            if(array[i].compareTo(current) == 0) continue;
            count++;
            current = array[i];
            endArray[count] = current;
        }
        return copyToLength(endArray, count + 1);
    }

    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> T[] copyToLength(T[] array, int length){
        T[] endArray = (T[]) new Comparable[length ];
        for(int i = 0; i < length; i++){
            endArray[i] = array[i];
        }
        return endArray;
    }
}
