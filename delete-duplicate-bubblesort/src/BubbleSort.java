public class BubbleSort {
    public static <T extends Comparable<T>> void sort(T[] array){

        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j].compareTo(array[j+1]) > 0){
                    swap(array, j, j+1);
                }
            }
        }
    }

    private static <T> void swap(T[] array, int i, int j){
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
