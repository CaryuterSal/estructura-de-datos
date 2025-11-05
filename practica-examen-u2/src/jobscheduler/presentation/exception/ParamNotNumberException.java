package jobscheduler.presentation.exception;

public class ParamNotNumberException extends TokenInvalidException {
    public ParamNotNumberException() {
        super("El argumento debe ser un número");
    }
}
