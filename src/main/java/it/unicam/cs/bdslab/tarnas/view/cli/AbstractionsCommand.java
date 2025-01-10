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

    private IOController ioController;

    private AbstractionsController abstractionsController;

    @ParentCommand
    private CLIController parent;

    private List<RNAFile> abstractions;

    // Abstraction options

    // generate core
    @Option(names = {"--core"}, description = "Generate core abstraction of the input RNA file")
    private boolean generateCore;

    // generate coreplus
    @Option(names = {"--core-plus"}, description = "Generate coreplus abstraction of the input RNA file")
    private boolean generateCorePlus;

    // generate shape
    @Option(names = {"--shape"}, description = "Generate shape abstraction of the input RNA file")
    private boolean generateShape;

    /**
     * Constructs a new AbstractionsCommand.
     */
    public AbstractionsCommand() {
        this.ioController = IOController.getInstance();
        this.abstractionsController = AbstractionsController.getInstance();
        this.abstractions = new ArrayList<>();
        this.generateCore = false;
        this.generateCorePlus = false;
        this.generateShape = false;
    }

    private void computeAbstractions() {
        try {
            for (var f : this.ioController.getLoadedRNAFiles()) {
                if (!this.generateCore && !this.generateCorePlus && !this.generateShape)
                    this.abstractions.addAll(List.of(
                            this.abstractionsController.getCore(f),
                            this.abstractionsController.getCorePlus(f),
                            this.abstractionsController.getShape(f)
                    ));
                else {
                    if (this.generateCore)
                        this.abstractions.add(this.abstractionsController.getCore(f));
                    if (this.generateCorePlus)
                        this.abstractions.add(this.abstractionsController.getCorePlus(f));
                    if (this.generateShape)
                        this.abstractions.add(this.abstractionsController.getShape(f));
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public void run() {
        this.computeAbstractions();
        this.parent.saveAbstractions(this.abstractions);
    }
}
