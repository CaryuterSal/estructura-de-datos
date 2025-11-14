import java.util.Arrays;

public class App {
    public static void main(String[] args){
        Integer[] arr = {4,7,1,6,53,12,7,1,0,23,5};
        System.out.println(Arrays.toString(arr));
        QuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
