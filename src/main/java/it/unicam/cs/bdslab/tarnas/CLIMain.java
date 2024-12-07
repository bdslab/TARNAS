package it.unicam.cs.bdslab.tarnas;

import it.unicam.cs.bdslab.tarnas.view.CLIController;
import picocli.CommandLine;
import picocli.CommandLine.Command;


@Command(name = "tarnas", mixinStandardHelpOptions = true, version = "tarnas 1.0",
        description = "A simple CLI tool for RNA file format conversion.")
public class CLIMain{

    public static void main(String... args) {
        new CommandLine(new CLIController()).execute(args);
    }
}
