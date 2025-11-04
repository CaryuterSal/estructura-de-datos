import java.math.BigInteger;
import java.util.Objects;
import java.util.StringJoiner;
//
public class Customer {
    private static BigInteger ID_COUNT =  BigInteger.ONE;

    private final BigInteger id;
    private final String name;

    {
        id = ID_COUNT;
        ID_COUNT = ID_COUNT.add(BigInteger.ONE);
    }

    public Customer(String name) {
        this.name = name;
    }

    public BigInteger id() {
        return id;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;
        return id.equals(customer.id) && Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + Objects.hashCode(name);
        return result;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Customer.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .toString();
    }
}
