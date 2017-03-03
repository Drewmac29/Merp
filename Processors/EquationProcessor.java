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
        //TODO
    }

    /**
     * //TODO
     * @param eq - //TODO
     */
    public void processEquation(java.lang.String eq){
        //TODO
    }

}
