package jobscheduler.presentation.exception;

public class ParamNegativeException extends TokenInvalidException {
    public ParamNegativeException(String command) {
        super("El argumento para %s debe ser un número positivo");
    }
}
