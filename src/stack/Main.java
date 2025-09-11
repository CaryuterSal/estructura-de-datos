package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class Main {

    private static final Deque<String> webPages = new ArrayDeque<>();
    public static void main(String[] args) {
        webPages.offer("httṕs://github.com");
        webPages.offer("http://google.com");
        webPages.offer("http://firebase.com");
        System.out.println("Retrocediendo una página, volviendo de " + webPages.pop());
        System.out.println("Estamos en la página: " + webPages.peek());
        webPages.offer("https://monkeytype.com");
        System.out.println("El contenido de la pila es" + webPages);
    }
}
