package matrix_add_sum_pair;

public class Main {
    public static void main(String[] args) {

        int[][] arrTest = new int[][]{
                {1},
                {6,3,1},
                {1,2,3,4},
                {0,5,3,0},
                {2,5,9},
                {2,4,8,9,10}
        };

        printMatrix(arrTest);
        System.out.println();

        for (int i = 0; i < arrTest.length; i++) {
            int rowLength = arrTest[i].length;
            arrTest[i] = copyArr(arrTest[i], arrTest[i].length + 1);
            if(rowLength % 2 == 0){
                arrTest[i][rowLength] = arrTest[i][0] + arrTest[i][rowLength - 1];
            } else {
                arrTest[i][rowLength] = 0;
            }
        }

        printMatrix(arrTest);

    }


    private static int[] copyArr(int[] arrTest, int length) {
        int[] arrCopy = new int[length];
        for (int i = 0; i < arrCopy.length; i++) {
            arrCopy[i] = i < arrTest.length ? arrTest[i] : 0;
        }
        return arrCopy;
    }


    private static void printMatrix(int[][] arr) {
        System.out.println("[");
        for(int i = 0; i < arr.length; i++){
            System.out.print("[ ");
            for(int j = 0; j < arr[i].length; j++){
                System.out.print(arr[i][j]);

                if(j < arr[i].length - 1){
                    System.out.print(", ");
                }
            }
            System.out.println(" ]");
        }
        System.out.println("]");
    }
}
