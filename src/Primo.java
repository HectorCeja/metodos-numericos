
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hector
 */
public class Primo {
    public static void main(String[] a){
       
            int n = 100;
            
            for(int i=2;i<n;i++){
              int contador=0;
              for(int j=1;j<n;j++){
                int aux=i%j;
                if(aux==0){
                    contador++;
                }   
              }
              if(contador<=2 && i>1){
                   System.out.println(i);
              }
            }
     }
                                      
            
}