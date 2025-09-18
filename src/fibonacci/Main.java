package fibonacci;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < Integer.parseInt(args[0]); i++) {
            System.out.printf("#%d: %d%n", i + 1, fibonacci(i));
        }
    }

    static int fibonacci(int n) {
        if (n <= 1) return n;
        return  fibonacci(n - 1) + fibonacci(n - 2);
    }
}
