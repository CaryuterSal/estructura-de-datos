import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Worker> workers = new ArrayList<>();

    public static void main(String[] args){
        addWorker("Carlos", 3000.43);
        addWorker("Daniel", 5000.5);
        addWorker("Rummy", 670.4);
        addWorker("Kevin", 3000);
        addWorker("Jose", 750);
        addWorker("Jenny", 130.7);
        System.out.printf("El promedio de sueldos es %s%n",formatCurrency(calculateAverage()));

        deleteGreaterThan(BigDecimal.valueOf(1000));
        System.out.println("Los sueldos menores a $1000 son: ");
        for(Worker worker: workers){
            System.out.printf("\t- %s : %s%n", worker.getName(), formatCurrency(worker.getSalary()));
        }
    }

    private static String formatCurrency(BigDecimal quantity){
        return  NumberFormat.getCurrencyInstance().format(quantity);
    }

    private static void addWorker(String name, double salary){
        workers.add(new Worker(name, BigDecimal.valueOf(salary)));
    }

    private static BigDecimal calculateAverage(){
        BigDecimal accum = BigDecimal.ZERO;
        for(Worker worker: workers){
            accum = accum.add(worker.getSalary());
        }
        return accum.divide(BigDecimal.valueOf(workers.size()), RoundingMode.HALF_EVEN);
    }

    private static void deleteGreaterThan(BigDecimal limit){
        List<Worker> workersToDelete = new ArrayList<>();
        for(Worker worker: workers){
            if(worker.getSalary().compareTo(limit) > 0){
                workersToDelete.add(worker);
            }
        }

        workers.removeAll(workersToDelete);
    }
}
