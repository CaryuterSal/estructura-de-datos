package jobscheduler.model;

import jobscheduler.model.common.Entity;
import jobscheduler.model.common.ValueObject;

import java.math.BigInteger;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.UUID;

public class Job implements Entity<Job.Id> {
    private final Id id;
    private String description;

    public Job(Id id, String description) {
        this.id = Objects.requireNonNull(id);
        this.description = Objects.requireNonNull(description);
    }

    public Id id() {
        return id;
    }

    public String description() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Job job = (Job) o;
        return id.equals(job.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Job.class.getSimpleName() + "[", "]")
                .add("id=" + id.toString())
                .add("description='" + description + "'")
                .toString();
    }

    public record Id(UUID value) implements ValueObject {

        public Id {
            validate(value);
        }

        private static void validate(UUID value){
            if(!isValid(value)){
                throw new IllegalArgumentException("Job ID is invalid");
            }
        }

        private static boolean isValid(UUID value) {
            return value != null;
        }

        public UUID value() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
