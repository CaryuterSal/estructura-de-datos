import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = new Integer[]{8,10,8,4,1,2};

        System.out.println(Arrays.toString(arr));
        Sorter<Integer> sorter = new BubbleSort<>();
        Integer[] sortedArr = sorter.sort(arr);
        System.out.println(Arrays.toString(sortedArr));


        String[] words = new String[]{"hola", "daniel", "a", "A", "b", "123"};
        System.out.println(Arrays.toString(words));
        Sorter<String> sorter2 = new BubbleSort<>();
        String[] sortedWords = sorter2.sort(words);
        System.out.println(Arrays.toString(sortedWords));
    }
}
