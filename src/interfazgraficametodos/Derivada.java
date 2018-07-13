/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgraficametodos;

/**
 *
 * @author Héctor
 */
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;
public class Derivada {
    
    public String derivada(String funcion){
        String derivada = "";
        DJep derivar = new DJep();
        derivar.addStandardFunctions();
        derivar.addStandardConstants();
        derivar.addComplex();
        derivar.setAllowUndeclared(true);
        derivar.setAllowAssignment(true);
        derivar.setImplicitMul(true);
        derivar.addStandardDiffRules();
        
        try{
            Node node = derivar.parse(funcion);
            Node diff = derivar.differentiate(node, "x");
            Node sim = derivar.simplify(diff);
            derivada = derivar.toString(sim);
            
        } catch(ParseException e){
            e.printStackTrace();
        }
  
        return derivada;
    }
}
