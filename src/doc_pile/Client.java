package doc_pile;

import java.util.ArrayDeque;
import java.util.Deque;

public class Client {

    private static int idCount;

    private final int id;
    private final Deque<String> documents ;
    private final String name;

    {
        id = idCount++;
    }

    private Client(String name, Deque<String> documents) {
        this.name = name;
        this.documents = documents;
    }

    public void addDocument(String document){
        documents.push(document);
    }

    public void attend(){
        System.out.printf("Cliente en atención: %s%n", name);
        if(documents.isEmpty()) {
            System.out.println("Este cliente no tiene documentos");
        }
        while(!documents.isEmpty()) {
            System.out.printf("Documento retirado: %s%n", documents.pop());
        }
    }

    public int id() {
        return id;
    }

    public Deque<String> documents() {
        return documents;
    }

    public String name() {
        return name;
    }

    public static NameStep builder(){
        return new Builder();
    }

    public static class Builder implements NameStep, DocumentStep{

        private final Deque<String> documents = new ArrayDeque<>();
        private String name;

        public DocumentStep name(String name){
            this.name = name;
            return this;
        }

        public DocumentStep addDocument(String document){
            documents.push(document);
            return this;
        }

        public Client build(){
            return new Client(name, documents);
        }
    }

    public interface NameStep{
        DocumentStep name(String name);
    }

    public interface DocumentStep extends BuildStep{
        DocumentStep addDocument(String document);
    }

    public interface BuildStep{
        Client build();
    }
}
