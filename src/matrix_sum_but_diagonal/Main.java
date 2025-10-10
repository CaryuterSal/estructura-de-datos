package matrix_sum_but_diagonal;

public class Main {
    public static void main(String[] args){

        int[][] arrTest={
                {1,3,7,8},
                {0,6,3,1},
                {1,2,3,4},
                {0,5,3,0},
                {2,5,9,0}
        };

        int accum = 0;
        StringBuilder builder = new StringBuilder("La suamtoria de ");
        for(int i = 0; i < arrTest.length; i++){
            for(int j = 0; j < arrTest[i].length; j++){
                if(j != i){
                    builder.append(arrTest[i][j]);
                    accum +=arrTest[i][j];
                    if(i != arrTest.length-1  || j != arrTest[i].length-1){
                        builder.append(", ");
                    }
                }
            }
        }
        builder.append(" es igual a ");
        builder.append(accum);
        System.out.println(builder.toString());
    }
}
