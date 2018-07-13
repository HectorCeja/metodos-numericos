/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgraficametodos;

import org.nfunk.jep.JEP;

/**
 *
 * @author Héctor
 */
public class Ecuacion {
    
    
    public double ecuacion(String a, double c) {

        JEP funcion = new JEP();
        //Permite utilizar las funciones básicas como las Trigonometricas, 
        //Logarítmicas, Exponenciales. 
        funcion.addStandardFunctions();
        // Permite utilizar las constantes "pi" y "e".
        funcion.addStandardConstants();

        // Permite 2x en vez de 2*x
        funcion.setImplicitMul(true);

        funcion.addVariable("X", c);
        funcion.addVariable("x", c);
        funcion.parseExpression(a);

        return funcion.getValue();

    }
}
