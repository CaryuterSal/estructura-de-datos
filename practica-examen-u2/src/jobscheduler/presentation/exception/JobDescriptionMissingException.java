package jobscheduler.presentation.exception;

public class JobDescriptionMissingException extends TokenInvalidException {
    public JobDescriptionMissingException() {
        super("Falta la descripción de la tarea");
    }
}
