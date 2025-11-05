package jobscheduler.model.common;

public interface Entity<ID> extends DomainObject {
    ID  id();
}
