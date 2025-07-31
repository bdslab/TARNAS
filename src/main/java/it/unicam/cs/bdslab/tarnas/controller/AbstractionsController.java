package it.unicam.cs.bdslab.tarnas.controller;

import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFile;
import it.unicam.cs.bdslab.tarnas.model.rnafile.RNAFormat;

import java.util.*;

public class AbstractionsController {

    private static AbstractionsController instance;


    public RNAFile getCorePlus(RNAFile rnaFile) throws IllegalArgumentException {
        var coreplus = computeCore(getDotBracket(rnaFile));
        var name = rnaFile.getFileName().substring(0, rnaFile.getFileName().lastIndexOf('.')) + "_coreplus";
        return new RNAFile(name, new ArrayList<>(), List.of(coreplus), null, RNAFormat.ABSTRACTION);
    }

    public RNAFile getCore(RNAFile rnaFile) throws IllegalArgumentException {
        var coreplus = computeCore(getDotBracket(rnaFile));
        var core = computeCore(coreplus);
        var name = rnaFile.getFileName().substring(0, rnaFile.getFileName().lastIndexOf('.')) + "_core";
        return new RNAFile(name, new ArrayList<>(), List.of(core), null, RNAFormat.ABSTRACTION);
    }

    public RNAFile getShape(RNAFile rnaFile) throws IllegalArgumentException {
        var shape = getDotBracket(rnaFile);
        try {
            shape = determineStructureShape(shape);
        } catch (Exception e) {
            shape = "";
        }
        var name = rnaFile.getFileName().substring(0, rnaFile.getFileName().lastIndexOf('.')) + "_shape";
        return new RNAFile(name, new ArrayList<>(), List.of(shape), null, RNAFormat.ABSTRACTION);
    }

    private String computeCore(String sequence) {
        var pairs = convertDotBracketToPairs(sequence);
        var corePlusPairs = extractValidPairs(pairs);

        return convertPairsToString(corePlusPairs, sequence);
    }

    private String getDotBracket(RNAFile rnaFile) throws IllegalArgumentException {
        if (rnaFile.getFormat() != RNAFormat.DB && rnaFile.getFormat() != RNAFormat.DB_NO_SEQUENCE)
            throw new IllegalArgumentException("Impossible to compute abstractions for " + rnaFile.getFormat() + " format");
        if (rnaFile.getFormat() == RNAFormat.DB_NO_SEQUENCE)
            return rnaFile.getBody().get(0);
        return rnaFile.getBody().get(1);
    }

    public List<int[]> convertDotBracketToPairs(String notation) {
        var length = notation.length();
        var roundBrackets = new Stack<Integer>();
        var squareBrackets = new Stack<Integer>();
        var curlyBrackets = new Stack<Integer>();
        var angleBrackets = new Stack<Integer>();
        var aBrackets = new Stack<Integer>();
        var bBrackets = new Stack<Integer>();
        var cBrackets = new Stack<Integer>();
        var dBrackets = new Stack<Integer>();
        var eBrackets = new Stack<Integer>();
        var fBrackets = new Stack<Integer>();
        var pairs = new ArrayList<int[]>();

        for (int i = 0; i < length; i++) {
            char currentChar = notation.charAt(i);
            switch (currentChar) {
                case '(' -> roundBrackets.push(i + 1);
                case ')' -> pairs.add(new int[]{roundBrackets.pop(), i + 1});
                case '[' -> squareBrackets.push(i + 1);
                case ']' -> pairs.add(new int[]{squareBrackets.pop(), i + 1});
                case '{' -> curlyBrackets.push(i + 1);
                case '}' -> pairs.add(new int[]{curlyBrackets.pop(), i + 1});
                case '<' -> angleBrackets.push(i + 1);
                case '>' -> pairs.add(new int[]{angleBrackets.pop(), i + 1});
                case 'A' -> aBrackets.push(i + 1);
                case 'a' -> pairs.add(new int[]{aBrackets.pop(), i + 1});
                case 'B' -> bBrackets.push(i + 1);
                case 'b' -> pairs.add(new int[]{bBrackets.pop(), i + 1});
                case 'C' -> cBrackets.push(i + 1);
                case 'c' -> pairs.add(new int[]{cBrackets.pop(), i + 1});
                case 'D' -> dBrackets.push(i + 1);
                case 'd' -> pairs.add(new int[]{dBrackets.pop(), i + 1});
                case 'E' -> eBrackets.push(i + 1);
                case 'e' -> pairs.add(new int[]{eBrackets.pop(), i + 1});
                case 'F' -> fBrackets.push(i + 1);
                case 'f' -> pairs.add(new int[]{fBrackets.pop(), i + 1});
                default -> {
                    if (currentChar != '.' && currentChar != '\n') {
                        System.out.println("Unexpected character: " + currentChar);
                    }
                }
            }
        }

        pairs.sort(Comparator.comparingInt(a -> a[0]));  // Sort pairs by the first element
        return pairs;
    }

    // Method to check and extract valid pairs (non-sequential)
    public List<int[]> extractValidPairs(List<int[]> pairs) {
        var validPairs = new ArrayList<int[]>();
        int lastOpen = 0, lastClose = 0;

        for (int[] pair : pairs) {
            if (lastOpen != 0 || lastClose != 0) {
                if (pair[0] != lastOpen + 1 || pair[1] != lastClose - 1) {
                    validPairs.add(new int[]{lastOpen, lastClose});
                }
            }
            lastOpen = pair[0];
            lastClose = pair[1];
        }
        validPairs.add(new int[]{lastOpen, lastClose});  // Add the final pair
        return validPairs;
    }

    // Convert pairs back to a string representation
    public String convertPairsToString(List<int[]> pairs, String input) {
        var resultArray = new char[input.length()];
        Arrays.fill(resultArray, '0');

        for (int[] pair : pairs) {
            resultArray[pair[0] - 1] = input.charAt(pair[0] - 1);
            resultArray[pair[1] - 1] = input.charAt(pair[1] - 1);
        }

        var resultString = new StringBuilder();
        for (char c : resultArray) {
            if (c != '0') {
                resultString.append(c);
            }
        }

        return resultString.toString();
    }

    // Determine the shape based on the input structure
    public String determineStructureShape(String input) {
        var shapeStack = new ArrayList<Character>();
        shapeStack.add('.');

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != '.') {
                if ("([{<ABCDEF".indexOf(currentChar) != -1) {
                    shapeStack.add(currentChar);
                } else {
                    char last = shapeStack.get(shapeStack.size() - 1);
                    if ((last == '(' && currentChar == ')') ||
                            (last == '[' && currentChar == ']') ||
                            (last == '{' && currentChar == '}') ||
                            (last == '<' && currentChar == '>') ||
                            (last == 'A' && currentChar == 'a') ||
                            (last == 'B' && currentChar == 'b') ||
                            (last == 'C' && currentChar == 'c') ||
                            (last == 'D' && currentChar == 'd') ||
                            (last == 'E' && currentChar == 'e') ||
                            (last == 'F' && currentChar == 'f')) {
                        shapeStack.remove(shapeStack.size() - 1);
                    } else {
                        shapeStack.add(currentChar);
                    }
                }
            }
        }

        var shapeBuilder = new StringBuilder();
        for (char c : shapeStack) {
            shapeBuilder.append(c);
        }

        var pairList = convertDotBracketToPairs(shapeBuilder.toString());
        var validPairs = extractValidPairs(pairList);
        return convertPairsToString(validPairs, shapeBuilder.toString());
    }

    public static AbstractionsController getInstance() {
        if (instance == null)
            instance = new AbstractionsController();
        return instance;
    }

}
