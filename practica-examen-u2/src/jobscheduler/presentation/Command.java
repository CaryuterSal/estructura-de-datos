package jobscheduler.presentation;

import jobscheduler.presentation.exception.InvalidCommandException;

public enum Command {
    ADD, PROCESS, COMMIT, ROLLBACK, PRINT, END, HELP;

    public static Command fromString(String value) {
        for (Command command : Command.values()) {
            if (command.name().equalsIgnoreCase(value))
                return command;
        }
        throw new InvalidCommandException(value);
    }
}
