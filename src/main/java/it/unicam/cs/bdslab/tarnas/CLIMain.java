package it.unicam.cs.bdslab.tarnas;

import it.unicam.cs.bdslab.tarnas.view.cli.CLIController;
import picocli.CommandLine;


public class CLIMain {
    public static void main(String... args) {
        var cmd = new CommandLine(new CLIController());

        if (args.length == 0) {
            cmd.usage(System.out);
            return;
        }

        //cmd.setExecutionStrategy(new CommandLine.RunAll());
        System.exit(cmd.execute(args));
    }
}
