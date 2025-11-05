import jobscheduler.infrastructure.LocalUniqueIdGenerator;
import jobscheduler.infrastructure.UniqueIdGenerator;
import jobscheduler.presentation.CmdApp;
import jobscheduler.presentation.CommandController;
import jobscheduler.service.JobScheduler;

public class Main {
    public static void main(String[] args) {
        UniqueIdGenerator idGenerator = new LocalUniqueIdGenerator();
        JobScheduler jobScheduler = new JobScheduler(idGenerator);
        CommandController commandController = new CommandController(jobScheduler);
        CmdApp app = new CmdApp(commandController);

        app.run();
    }
}
