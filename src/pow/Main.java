package pow;

public class Main {
    public static void main(String[] args) {

        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.printf("%d^%d = %d", a, b, pow(a, b));
        } catch (NumberFormatException e) {
            System.out.println("Ambos números tienen que ser enteros");
        }
    }

    private static int pow(int a, int b){
        if(b == 0) return 1;
        return a*pow(a, b-1);
    }
}
