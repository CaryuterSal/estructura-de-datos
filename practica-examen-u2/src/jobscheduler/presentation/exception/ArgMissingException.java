package jobscheduler.presentation.exception;

public class ArgMissingException extends TokenInvalidException {
    public ArgMissingException() {
        super("Falta el argumento del comando");
    }
}
