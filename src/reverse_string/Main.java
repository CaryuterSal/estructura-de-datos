package reverse_string;

public class Main {
    public static void main(String[] args) {
        String input = args[0];
        System.out.printf("El reverso de la cadena \"%s\" es \"%s\"", input, reverseString(input));
    }

    private static String reverseString(String str) {
        if(str == null || str.isEmpty()) return str;
        return reverseString(str.substring(1)).concat(str.substring(0,1));
    }
}
