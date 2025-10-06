package subjects_search;

import java.util.Scanner;

public class Main {

    private static final SubjectsList subjectsList = new SubjectsList();

    public static void main(String[] args) {
        subjectsList.add("Matemáticas");
        subjectsList.add("Física");
        subjectsList.add("Química");
        subjectsList.add("Historia");
        subjectsList.add("Programación");
        searchByConsole();
    }

    private static void searchByConsole(){
        System.out.println("Ingresa la materia a buscar");
        System.out.print("\t> ");
        try(Scanner sc = new Scanner(System.in)){
            String query = sc.nextLine();
            if(subjectsList.contains(query)){
                System.out.println("Resultado: Materia encontrada");
            } else {
                System.out.println("Resultado: No se encontró el materia");
            }
        }
    }
}
