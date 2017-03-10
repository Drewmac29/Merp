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
            temp = temp.trim();
            java.util.ArrayList<String> statements = new java.util.ArrayList<>(java.util.Arrays.asList(temp.split(",")));
            java.util.ArrayList<String> string = new java.util.ArrayList<>(java.util.Arrays.asList(statements.get(0).split(" ")));
            java.util.ArrayList<String> tokens = new java.util.ArrayList<>();
            for (int i = 0; i < string.size(); i++)
                tokens.add(string.get(i));
            processor.constructTree(tokens);
            int bool = processor.evaluateTree(symbolTable);
            String element;
            if (bool != 0) {
                element = statements.get(1).trim().substring(6);
            }
            else {
                element = statements.get(2).trim().substring(6);
            }
            element = element.trim();
            if (element.matches("^[a-zA-Z].*") && element.length() == 1) {
                System.out.println(symbolTable.get(element));
            }
            else{
                java.util.ArrayList<String> tokens2 = new java.util.ArrayList<>(java.util.Arrays.asList(element.split(" ")));
                processor.constructTree(tokens2);
                System.out.println(processor.evaluateTree(symbolTable));
            }
        }
        else if (eq.contains("while")){
            String temp = eq.substring(6).replaceAll("\\)", "");
            temp = temp.trim();
            java.util.ArrayList<String> statements = new java.util.ArrayList<>(java.util.Arrays.asList(temp.split(",")));
            java.util.ArrayList<String> string = new java.util.ArrayList<>(java.util.Arrays.asList(statements.get(0).split(" ")));
            java.util.ArrayList<String> loop = new java.util.ArrayList<>();
            java.util.ArrayList<String> statements2 = new java.util.ArrayList<>(java.util.Arrays.asList(statements.get(1).split(";")));
            for (int i = 0; i < string.size(); i++)
                loop.add(string.get(i));
            int cont = 0;
            //Local variable to determine if loop should continue
            while (cont == 0){
                processor.constructTree(loop);
                if (processor.evaluateTree(symbolTable) == 0)
                    //Sets cont to 1, to exit the while loop
                    cont = 1;
                else{
                    for (String line : statements2){
                        line = line.trim();
                        if (line.contains("print")){
                            String element = line.substring(6);
                            if (element.matches("^[a-zA-Z].*") && element.length() == 1) {
                                System.out.println(symbolTable.get(element));
                            }
                            else{
                                java.util.ArrayList<String> tokens = new java.util.ArrayList<>(java.util.Arrays.asList(element.split(" ")));
                                processor.constructTree(tokens);
                                System.out.println(processor.evaluateTree(symbolTable));
                            }
                        }
                        else{
                            java.util.ArrayList<String> string2 = new java.util.ArrayList<>(java.util.Arrays.asList(line.split(" ")));
                            java.util.ArrayList<String> tokens = new java.util.ArrayList<>();
                            for (int i = 2; i < string2.size(); i++)
                                tokens.add(string2.get(i));
                            processor.constructTree(tokens);
                            symbolTable.put(string2.get(0), processor.evaluateTree(symbolTable));
                        }
                    }
                }
            }
        }
        else if (eq.contains("print")){
            String element = eq.substring(6).replaceAll("\\)", "");
            if (element.matches("^[a-zA-Z].*") && element.length() == 1) {
                System.out.println(symbolTable.get(element));
            }
            else{
                java.util.ArrayList<String> tokens = new java.util.ArrayList<>(java.util.Arrays.asList(element.split(" ")));
                processor.constructTree(tokens);
                System.out.println(processor.evaluateTree(symbolTable));
            }
        }
        else{
            eq = eq.trim();
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
