package jobscheduler.infrastructure;

import java.util.UUID;

public interface UniqueIdGenerator {
    UUID generate();
}
