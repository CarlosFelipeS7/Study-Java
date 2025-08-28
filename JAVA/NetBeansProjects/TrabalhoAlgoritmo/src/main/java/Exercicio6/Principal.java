/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio6;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner ler = new Scanner(System.in);
       Trapezio trapezio = new Trapezio();
       
        System.out.println("Digite a base maior: ");
        double baseMaior = ler.nextDouble();
        
        System.out.println("Digite a base menor: ");
        double baseMenor = ler.nextDouble();
        
         System.out.println("Digite a altura: ");
        double altura = ler.nextDouble();
        
        System.out.println("Area do trapezio: " + trapezio.Trapezio(baseMaior, baseMenor, altura));
        
        
    }
    
}
