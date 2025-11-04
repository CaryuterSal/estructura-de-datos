public class Main {
    public static void main(String[] args)
    {
        logIsPalindrome("Anita lava la tina");
        logIsPalindrome("Hola");
    }

    public static void logIsPalindrome(String word)
    {

        System.out.printf("La palabra \"%s\" es palíndromo? %b%n", word, isPalindrome(word));
    }

    public static boolean isPalindrome(String word)
    {
        String filteredWord = word.toLowerCase().replaceAll("\\s+", "");
        IStack<Character> stack = new Stack<>();

        for (int i = 0; i < filteredWord.length(); i++) {
            stack.push(filteredWord.charAt(i));
        }

        for (int i = 0; i < filteredWord.length(); i++) {
            if (stack.pop() != filteredWord.charAt(i)) return false;
        }

        return true;
    }
}
