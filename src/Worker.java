import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Objects;

public class Worker {
    private static int idCounter;
    private final int id;
    private final String name;
    private BigDecimal salary;

    {
        idCounter ++;
        id = idCounter;
    }

    public Worker(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return id == worker.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
