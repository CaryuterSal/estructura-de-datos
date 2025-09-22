package doc_pile;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final Queue<Client> clients = new ArrayDeque<>();
    public static void main(String[] args) {
        clients.offer(Client.builder()
                .name("Carlos")
                .addDocument("profile.jpg")
                .addDocument("CV.pdf")
                .build());
        clients.offer(Client.builder()
                .name("Pedro")
                .addDocument("information.txt")
                .addDocument("CV_extended")
                .build());
        clients.offer(Client.builder()
                .name("Maria")
                .addDocument("no_info.txt")
                .build());
        clients.offer(Client.builder()
                .name("Salgado")
                .build());

        int totalClients = clients.size();
        for(int i = 0; i < totalClients; i++){
            Client client = clients.poll();
            client.attend();
            if(i == totalClients - 1){
                System.out.println("No quedan más clientes");
            } else {
                System.out.printf("Clientes restantes: %s%n", clients.stream().map(Client::name).toList());
            }
            System.out.println("---------------------------");
        }
    }
}
