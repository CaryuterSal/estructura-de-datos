package jobscheduler.presentation.exception;

public class MissingQuoteException extends TokenInvalidException {
    public MissingQuoteException() {
        super("Faltan las comillas de cierre para el argumento o el tipo de comilla no coincide");
    }
}
