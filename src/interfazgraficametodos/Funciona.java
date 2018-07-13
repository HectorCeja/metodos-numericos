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
import org.nfunk.jep.*;
import org.lsmp.djep.djep.*;
import org.nfunk.jep.*;
import org.lsmp.djep.djep.*;
public class Funciona {
    JEP j =new JEP();
public  Funciona(String funcion)
{
    j.addVariable("x",0);
    j.addStandardConstants();
    j.addStandardFunctions();
    j.parseExpression(funcion);
    if(j.hasError())
    {
        System.out.println(j.getErrorInfo());
    }
    
}    
    public double calc(double x)
    {
        double r;
        j.addVariable("x", x);
        r=j.getValue();
        if(j.hasError())
        {
            System.out.println(j.getErrorInfo());
        }
        return r;
    }
    public String calcul(double x)
    {
        double p;
        String r="";
        j.addVariable("x", x);
        p=j.getValue();
        r= String.valueOf(p); 
        if(j.hasError())
        {
            System.out.println(j.getErrorInfo());
        }
        return r;
      
    }
	
}

