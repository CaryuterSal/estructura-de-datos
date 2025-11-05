package jobscheduler.presentation.exception;

public class TokenInvalidException extends RuntimeException {
    public TokenInvalidException(String message) {
        super("\tCOMANDO INVÁLIDO: " + message);
    }
}
