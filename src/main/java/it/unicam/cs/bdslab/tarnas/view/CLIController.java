package it.unicam.cs.bdslab.tarnas.view;

import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

public class CLIController  implements Callable<Integer> {

    // Input RNA file path or RNA directory path
    @Parameters(index = "0", description = "Input RNA file path or RNA directory path")
    private String inputPath;

    // Output RNA directory path
    @Parameters(index = "1", description = "Output directory path")
    private String outputDirectoryPath;

    // Cleaning options

    // remove all comments from the input file
    @Option(names = {"-c", "--rcomments"}, description = "Remove all comments from the input file")
    private boolean removeComments;


    // remove lines containing an input string from the input file
    @Option(names = {"-r", "--rlines"}, description = "Remove lines containing an input string from the input file")
    private String removeString;

    // remove all empty lines from the input file
    @Option(names = {"-e", "--empty"}, description = "Remove all empty lines from the input file")
    private boolean removeEmptyLines;

    // merge all lines in the input file only for DB and DB NO SEQUENCE formats
    @Option(names = {"-m", "--merge"}, description = "Merge all lines in the input file only for DB and DB NO SEQUENCE formats")
    private boolean mergeLines;

    // Translation options

    // include the header in the output file
    @Option(names = {"-h", "--header"}, description = "Include the header in the output file")
    private boolean includeHeader;

    // generate non canonical pairs (only for RNAML input format)
    @Option(names = {"-n", "--non-canonical"}, description = "Generate non canonical pairs (only for RNAML input format)")
    private boolean generateNonCanonicalPairs;

    // translate to the specified destination format
    @Option(names = {"-t", "--translate"}, description = "Translate to the specified destination format")
    private String destinationFormat;

    // Abstraction options

    // generate core
    @Option(names = {"-g", "--generate"}, description = "Generate core")
    private boolean generateCore;

    // generate coreplus
    @Option(names = {"-G", "--generate-plus"}, description = "Generate coreplus")
    private boolean generateCorePlus;

    // generate shape
    @Option(names = {"-s", "--shape"}, description = "Generate shape")
    private boolean generateShape;

    @Override
    public Integer call() throws Exception {

        // print the names in reverse order if the option is specified, otherwise print them in the order they are given
        System.out.print("Hello ");
        if (reverseOrder) {
            for (int i = inputFilePath.length() - 1; i >= 0; i--) {
                System.out.print(inputFilePath.charAt(i));
            }
            System.out.println();
        } else {
            System.out.println(inputFilePath);
        }
        return 0;
    }
}
