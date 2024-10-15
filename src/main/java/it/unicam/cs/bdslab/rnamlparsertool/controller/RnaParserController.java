package it.unicam.cs.bdslab.rnamlparsertool.controller;

import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaDataLoader;
import it.unicam.cs.bdslab.rnamlparsertool.abstraction.RnaFileWriter;
import it.unicam.cs.bdslab.rnamlparsertool.model.OperationResult;
import it.unicam.cs.bdslab.rnamlparsertool.model.RnaMolecule;
import it.unicam.cs.bdslab.rnamlparsertool.service.writer.TertiaryStructureWriter;
import it.unicam.cs.bdslab.rnamlparsertool.utility.DefaultRnaHandlerBuilder;
import it.unicam.cs.bdslab.rnamlparsertool.utility.RnaFileNameHandler;
import it.unicam.cs.bdslab.rnamlparsertool.utility.RnaHandlerBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;



/**
 * Controller Facade, centrale in questo tool
 * Mette insieme tutte le funzioni della libreria
 * Un ipotetico utilizzo esterno dovrà passare da qui
 *
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaParserController {

    /**
     * dati caricati pronti per essere scritti
     */
    private RnaMolecule chains;
    /**
     * costruttore di gestori di dati rna
     */
    private RnaHandlerBuilder builder;
    /**
     * Nome del file caricato
     */
    private String loadedPath;
    /**
     * classe per la gestione di nomi di file imprevisti
     */
    private RnaFileNameHandler nameHandler;

    private TertiaryStructureWriter tertiaryWriter;

    /**
     * Costruttore del controller
     */
    public RnaParserController() {
        this(new DefaultRnaHandlerBuilder());
    }

    /**
     * Costruttore del controller con builder custom
     *
     * @param builder builder esteso con nuovi formati
     */
    public RnaParserController(RnaHandlerBuilder builder) {
        this.builder = builder;
        this.nameHandler = new RnaFileNameHandler();
        this.tertiaryWriter = new TertiaryStructureWriter();
    }

    /**
     * Metodo per caricare i dati di un rna contenuti in un dati file
     *
     * @param path nome del file
     * @return esito dell'operazione
     */
    public synchronized OperationResult loadRna(String path) {
        path = checkExt(path, false);
        RnaDataLoader loader = builder.buildDataLoader(path);
        chains = loader.getData(path);
        OperationResult result = new OperationResult();
        if (isLoaded()) {
            loadedPath = path;
            result.result = true;
            result.addInfo("Load " + chains.getchains().size() + " chains.");
            for (int i = 0; i < chains.getchains().size(); i++) {
                result.addInfo("chain n." + i + " with " +
                        chains.getchains().get(i).getLength() + " ribonucleotides.");
            }
        } else {
            result.addInfo("Failure to load data.");
        }
        return result;
    }

    /**
     * metodo per controllare se i dati sono attualmente stati caricati
     *
     * @return true se caricati, false altrimenti
     */
    public boolean isLoaded() {
        return chains != null;
    }

    /**
     * Metodo per cancellare i dati caricati
     */
    public void clean() {
        this.chains = null;
    }

    /**
     * Metodo per salvare i dati caricati in un dato file
     *
     * @param path nome del file
     * @return esito dell'operazione
     */
    public synchronized OperationResult SaveLoadedData(String path) {
        OperationResult result = new OperationResult();
        if (path == null || (!isLoaded())) {
            result.addInfo(path == null ? "Error. Path is null." : "Error. Data to save not loaded.");
            return result;
        }
        var extension = path.substring(path.lastIndexOf('.') + 1);
        if (extension.equals("fasta")) {
            return this.fastaTranslation(this.loadedPath,path);
        } else {
            path = checkExt(path, true);
            RnaFileWriter writer = this.builder.buildFileWriter(path);
            result.result = writer.writeAndSave(chains, path);
            result.addInfo(result.result ? "Saving to file " + path + " was successful."
                    : "Failed to save data in " + path + " file.");
            if (result.result && chains.haveTertiaryData() && (!Files.exists(Paths.get(loadedPath + ".csv")))) {
                result.result = this.tertiaryWriter.writeAndSave(chains, loadedPath + ".csv");
                result.addInfo(result.result ? "Saving to tertiary structure was successful."
                        : "Saving to tertiary structure was failed.");
            }
            return result;
        }
    }

    /**
     * Metodo che fa uso nel nameHandler
     *
     * @param path    path da controllare
     * @param newFile true se è un nuovo file
     * @return path sicuro
     */
    public String checkExt(String path, boolean newFile) {
        return this.nameHandler.checkExt(this.builder.getSupportedExtensions(), this.builder.getDefaultExtension(), path, newFile);
    }

    public RnaHandlerBuilder getBuilder() {
        return builder;
    }

    public String getLoadedPath() {
        return loadedPath;
    }

    private OperationResult fastaTranslation(String input,String output) {
        var r = new OperationResult();
        try {
            var in = Path.of(input);
            var out = Path.of(output);
            var content = String.join("", Files.readAllLines(in)).replaceAll("\\s+", "");
            content = content.replaceAll(".*?<seq-data>(.*?)</seq-data>.*", "$1");
            content = content.isEmpty() ? "" : content;
            Files.writeString(out, content);
            r.result = true;
            return r;
        } catch (IOException e) {
            r.result = false;
            return r;
        }
    }

}
