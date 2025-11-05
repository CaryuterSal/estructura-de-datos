package jobscheduler.presentation;

import jobscheduler.presentation.exception.TokenInvalidException;

import java.util.Scanner;

public class CmdApp {

    private final CommandController commandController;

    public CmdApp(CommandController commandController) {
        this.commandController = commandController;
    }
    private String askCommand(Scanner scanner) {
        System.out.print("\n(~)> ");
        return scanner.nextLine();
    }

    public void run(){
        showInstructions();
        try(Scanner sc = new Scanner(System.in)) {
            while (true) {
                String input = askCommand(sc);
                try {
                    Token parsedCommand =  Tokenizer.parse(input);
                    if (commandController.doWithCommand(parsedCommand)) break;
                } catch (TokenInvalidException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public static void showInstructions(){
        System.out.println("""
        Comandos del sistema:
               \s
          ADD description
          Agrega un nuevo trabajo a la cola de espera.

          PROCESS n
          Toma los primeros n trabajos de la cola y los pasa al stack (para procesarlos).

          COMMIT
          Confirma lo procesado y lo guarda en la bitácora.

          ROLLBACK m
          Deshace los últimos m trabajos confirmados y los regresa a la cola.

          PRINT
          Muestra cómo están actualmente las 3 estructuras (cola, stack y bitácora).

          END
          Finaliza el programa y muestra el estado final.
          \s
          HELP
          Obtén esta ayuda de comandos
               \s
       \s""");

    }
}
