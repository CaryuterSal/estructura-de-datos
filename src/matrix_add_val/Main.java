package matrix_add_val;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[][] arrTest={
                {1},
                {6,3,1},
                {1,2,3,4},
                {0,5,3,0},
                {2,5,9},
                {2,4,8,9,10}
        };
        printArr(arrTest);
        appendNextNumToArrRows(arrTest);
        System.out.println("Matriz modificada");
        printArr(arrTest);
    }

    static void appendNextNumToArrRows(int[][] arrTest){
        for(int i=0;i<arrTest.length;i++){
            arrTest[i] = Arrays.copyOf(arrTest[i], arrTest[i].length+1);
            arrTest[i][arrTest[i].length - 1] = arrTest[i][arrTest[i].length - 2] + 1;
        }
    }

    static void printArr(int[][] arr){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < arr.length; i++){
            sb.append("\n\t[");
            for(int j = 0; j < arr[i].length; j++){
                sb.append(arr[i][j]);
                if(j != arr[i].length-1){
                    sb.append(", ");
                }
            }
            sb.append("]");
        }
        sb.append("\n]");
        System.out.println(sb.toString());
    }
}
