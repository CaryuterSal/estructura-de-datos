package add_natural_num;

public class Main {
    public static void main(String[] args) {
        try{
            int firstNatural = Integer.parseInt(args[0]);
            System.out.printf("La suma de los primeros %d números: %d", firstNatural, addFirstNaturals(firstNatural));
        } catch (NumberFormatException e) {
            System.out.println("Input inválido, debe ser entero");
        }
    }

    private static int addFirstNaturals(int n){
        if(n == 0) return 0;
        return n + addFirstNaturals(n-1);
    }
}
