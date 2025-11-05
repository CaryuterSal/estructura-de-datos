package jobscheduler.presentation;

import jobscheduler.service.JobScheduler;

import java.util.UUID;

public class CommandController {

    private final JobScheduler jobScheduler;

    public CommandController(JobScheduler jobScheduler) {
        this.jobScheduler = jobScheduler;
    }

    boolean doWithCommand(Token token){
        switch (token.command()){

            case ROLLBACK -> {
                int rollbackCount = jobScheduler.rollback(Integer.parseInt(token.param()));
                System.out.println("\tRolled back " + rollbackCount + " jobs");
            }
            case PROCESS -> {
                int processCount = jobScheduler.process(Integer.parseInt(token.param()));
                System.out.println("\tProcessed " + processCount + " jobs");
            }
            case ADD -> {
                UUID id = jobScheduler.submit(token.param());
                System.out.println("\tSubmitted " + id.toString());
            }
            case COMMIT -> {

                int commitCount = jobScheduler.commit();
                System.out.println("\tCommited " + commitCount + " jobs");
            }
            case PRINT -> {
                printWithHeader("==== Estado Actual ====");
            }
            case END -> {
                printWithHeader("==== Estado Final ====");
                return true;
            }
            case HELP -> {
                CmdApp.showInstructions();
            }
        }
        return false;
    }

    private void printWithHeader(String header) {
        String sb = header + "\nQUEUE (pendiente)" +
                jobScheduler.pendingQueue().toString() +
                "\nSTACK (procesando)" +
                jobScheduler.processingStack().toString() +
                "\nBITÁCORA (confirmado)" +
                jobScheduler.commitLog().toString();
        System.out.println(sb);
    }
}
