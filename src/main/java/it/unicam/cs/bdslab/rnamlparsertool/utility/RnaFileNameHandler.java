package it.unicam.cs.bdslab.rnamlparsertool.utility;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * Classe utile a gestire path improri inseriti come input del tool
 * @author Marvin Sincini - Università di Informatica di Camerino - matricola 118311
 */
public class RnaFileNameHandler {

    /**
     * metodo per aggiustare un ipotetico path errato
     * @param exts estensioni supportate attualmente
     * @param def estensione di default
     * @param path path da controllare
     * @param newFile se è un nuovo file
     * @return path sicuro
     */
    public String checkExt(String[] exts, String def, String path, boolean newFile) {
        path = authomaticExtension(exts, def, path);
        if(newFile)
            path = checkFileExist(path);
        return path;
    }

    /**
     * metodo per aggiungere un estensione di default se
     * il path non ne ha una supportata
     * @param exts estensioni supportate
     * @param def estensione di default
     * @param path path non sicuro
     * @return path sicuro
     */
    private String authomaticExtension(String[] exts, String def, String path) {
        String[] parts = path.split("\\.");
        String extension = parts[parts.length - 1];
		if(extension.equals("txt") && parts.length > 2)
            extension = parts[parts.length - 2];
        for(String ext : exts) {
            if(ext.equals(extension))
                return path;
        }
        return path + "." + def;
    }

    /**
     * Metodo chiamato sse il file è nuovo
     * si assicura che non esista già e nel caso
     * genera un nuovo path non già preso
     * @param path path da controllare
     * @return path non ancora preso
     */
    private String checkFileExist(String path){
        if(!Files.exists(Paths.get(path))){
            return path;
        }
        String newPath;
        int count = 1;
        do{
            String[] parts = path.split("\\.");
            parts[parts.length - 2] += "_" + count++;
            newPath = Arrays.asList(parts).stream().reduce("", (a, b) -> a + ( a.equals("") ? "" : ".") + b);
        }while(Files.exists(Paths.get(newPath)));
        return newPath;
    }
}
