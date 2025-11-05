package jobscheduler.infrastructure;

import java.util.UUID;

public class LocalUniqueIdGenerator implements UniqueIdGenerator {
    @Override
    public UUID generate() {
        return UUID.randomUUID();
    }
}
