package it.unicam.cs.bdslab.tarnas;

import it.unicam.cs.bdslab.tarnas.view.CLIController;
import picocli.CommandLine;


public class CLIMain {
    public static void main(String... args) {
        var cmd = new CommandLine(new CLIController());

        if (args.length == 0) {
            cmd.usage(System.out);
            return;
        }

        cmd.execute(args);
    }
}
