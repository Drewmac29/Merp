package Processors;
import Util.SymbolTable;

/**
 * file: EquationProcessor.java
 * created: 3-2-17
 * author: Andrew Gingras
 */

public class EquationProcessor {

    MerpProcessor processor;
    SymbolTable symbolTable;
    java.util.ArrayList<java.lang.String> equations;

    /**
     * Constructor to create an Equation Processor. Creates an empty SymbolTable
     * @param equations - ArrayList containing the equations
     * @param processor - the Merp processor to use to process expressions
     */
    public EquationProcessor(java.util.ArrayList<java.lang.String> equations, MerpProcessor processor){
        this.equations = equations;
        this.processor = processor;
        symbolTable = new SymbolTable();
    }

    /**
     * Processes the provided list of statements using the provided Merp Processor and Symbol Table
     */
    public void processEquations(){
        for (java.lang.String equation : equations){
            processEquation(equation);
        }
    }

    /**
     * Processes a single equation
     * @param eq - equation string to be processed
     */
    public void processEquation(java.lang.String eq){
        if (eq.equals("printVariables()")){
            symbolTable.dump();
        }
        else if (eq.contains("if")){
            String temp = eq.substring(3).replaceAll("\\)", "");
            java.util.ArrayList<String> list = new java.util.ArrayList<>(java.util.Arrays.asList(temp.split(",")));
            for (String el : list) {
                el.trim();
                el.split(" ");
            }





        }
        else if (eq.contains("print")){
            String element = eq.substring(6).replaceAll("\\)", "");
            if (element.matches("^[a-zA-Z].*") && element.length() == 1) {
                System.out.print(symbolTable.get(element));
            }
            else{
                java.util.ArrayList<String> tokens = new java.util.ArrayList<>(java.util.Arrays.asList(element.split(" ")));
                processor.constructTree(tokens);
                System.out.println(processor.evaluateTree(symbolTable));
            }
        }
        else{
            java.util.ArrayList<String> string = new java.util.ArrayList<>(java.util.Arrays.asList(eq.split(" ")));
            if (string.get(1).equals("=")) {
                java.util.ArrayList<String> tokens = new java.util.ArrayList<>();
                for (int i = 2; i < string.size(); i++)
                    tokens.add(string.get(i));
                processor.constructTree(tokens);
                symbolTable.put(string.get(0), processor.evaluateTree(symbolTable));
            }
            else{
                processor.constructTree(string);
                System.out.println(processor.evaluateTree(symbolTable));
            }
        }
    }

}
