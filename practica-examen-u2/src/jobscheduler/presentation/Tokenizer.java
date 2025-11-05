package jobscheduler.presentation;

import jobscheduler.presentation.exception.*;

public class Tokenizer {
    public static Token parse(String line) {
        line = line.trim();
        int firstSpace = line.indexOf(' ');
        String cmdStr = (firstSpace == -1) ? line : line.substring(0, firstSpace);
        Command command = Command.fromString(cmdStr.toUpperCase());

        String param = getParam(line, firstSpace);

        if((command == Command.PROCESS || command == Command.ROLLBACK)){
            if(param == null){
                throw new ArgMissingException();
            }
            try{
                int a = Integer.parseInt(param);
                if(a <= 0) throw new ParamNegativeException(command.name());
            } catch(NumberFormatException e){
                throw new ParamNotNumberException();
            }
        }
        if(command == Command.ADD && param == null ){
            throw new JobDescriptionMissingException();
        }
        return new Token(command, param);
    }

    private static String getParam(String line, int firstSpace) {
        String param = null;

        if (firstSpace != -1) {
            String rest = line.substring(firstSpace).trim();
            if (rest.startsWith("\"") || rest.startsWith("'")) {

                char quoteType = rest.startsWith("\"") ? '\"' : '\'';
                int endQuote = rest.indexOf(quoteType, 1);
                if (endQuote == -1) {
                    throw new MissingQuoteException();
                }
                param = rest.substring(1, endQuote);
            } else {
                String[] parts = rest.split("\\s+");
                param = parts[0];
            }
        }
        return param;
    }
}
