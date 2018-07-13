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
public class CopiaArreglo {

    public double[][] duplicaMatriz(double[][] a) {
        double[][] copia = new double[a.length][a.length + 1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                copia[i][j] = a[i][j];
            }
        }
        return copia;
    }

    /*public static void main(String[] arg) {
        Scanner leer = new Scanner(System.in);
        System.out.println("ingresa el numero de incognitas del sistema");
        int incognitas = leer.nextInt();
        double[][] matrizaumentada = new double[incognitas][incognitas + 1];
        for (int i = 0; i < incognitas; i++) {
            System.out.println("ingresa los datos de la ecuacion " + (i + 1));
            for (int j = 0; j < incognitas + 1; j++) {
                System.out.println("[" + i + "]" + "[" + j + "]:");
                matrizaumentada[i][j] = leer.nextDouble();
            }
        }
        System.out.println("MATRIZ ORIGINAL");
        for (int i = 0; i < matrizaumentada.length; i++) {
            for (int j = 0; j < matrizaumentada[i].length; j++) {
                System.out.print(matrizaumentada[i][j] + "\t");
            }
            System.out.println("");
        }

        double[][] matrizcopia = new double[matrizaumentada.length][matrizaumentada.length + 1];
        for (int i = 0; i < matrizaumentada.length; i++) {
            for (int j = 0; j < matrizaumentada[i].length; j++) {
                matrizcopia[i][j] = matrizaumentada[i][j];
            }
            System.out.println("");
        }

        System.out.println("\nMATRIZ COPIA");
        for (int i = 0; i < matrizaumentada.length; i++) {
            for (int j = 0; j < matrizaumentada[i].length; j++) {
                System.out.print(matrizcopia[i][j] + "\t");
            }
            System.out.println("");
        }
    }*/
}
