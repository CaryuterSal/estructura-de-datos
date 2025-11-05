package jobscheduler.presentation.exception;

public class InvalidCommandException extends TokenInvalidException {
    public InvalidCommandException(String misspelledCommand) {
        super("Comando inválido: %s".formatted(misspelledCommand));
    }
}
