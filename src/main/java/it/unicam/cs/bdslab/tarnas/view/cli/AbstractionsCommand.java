package it.unicam.cs.bdslab.tarnas.view.cli;

import it.unicam.cs.bdslab.tarnas.controller.AbstractionsController;
import it.unicam.cs.bdslab.tarnas.controller.IOController;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParentCommand;
import picocli.CommandLine.Option;

import java.util.ArrayList;
import java.util.List;

@Command(
        name = "abstractions",
        mixinStandardHelpOptions = true,
        description = "Computes abstractions of the input RNA file. By default, it computes core, coreplus and shape abstractions.",
        version = "TARNAS 1.0"
)
public class AbstractionsCommand implements Runnable {

    private final IOController ioController;

    private final AbstractionsController abstractionsController;

    @ParentCommand
    private CLIController parent;

    private final List<RNAFile> abstractions;

    // Abstraction options

    // generate core
    @Option(names = {"--core"}, description = "Generate core abstraction of the input RNA file", defaultValue = "false")
    private boolean generateCore;

    // generate coreplus
    @Option(names = {"--core-plus"}, description = "Generate coreplus abstraction of the input RNA file", defaultValue = "false")
    private boolean generateCorePlus;

    // generate shape
    @Option(names = {"--shape"}, description = "Generate shape abstraction of the input RNA file", defaultValue = "false")
    private boolean generateShape;

    /**
     * Constructs a new AbstractionsCommand.
     */
    public AbstractionsCommand() {
        this.ioController = IOController.getInstance();
        this.abstractionsController = AbstractionsController.getInstance();
        this.abstractions = new ArrayList<>();
    }

    private void computeAbstractions() {
        for (var f : ioController.getLoadedRNAFiles()) {
            try {
                if (!generateCore && !generateCorePlus && !generateShape)
                    abstractions.addAll(List.of(
                            abstractionsController.getCore(f),
                            abstractionsController.getCorePlus(f),
                            abstractionsController.getShape(f)
                    ));
                else {
                    if (generateCore)
                        abstractions.add(abstractionsController.getCore(f));
                    if (generateCorePlus)
                        abstractions.add(abstractionsController.getCorePlus(f));
                    if (generateShape)
                        abstractions.add(abstractionsController.getShape(f));
                }

            } catch (Exception e) {
                System.err.println("Error caused by: " + f.getFileName());
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }

    @Override
    public void run() {
        computeAbstractions();
        parent.saveFiles(abstractions, false, false);
    }
}
