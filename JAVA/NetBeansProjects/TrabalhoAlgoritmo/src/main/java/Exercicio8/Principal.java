/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio8;

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
        Losango losango = new Losango();
        
        System.out.println("Digite a diagonal maior: ");
        double diagonalMaior = ler.nextDouble();
        
        System.out.println("Digite a diagonal menor: ");
        double diagonalMenor = ler.nextDouble();
        
        System.out.println("Area do losango: " + losango.Losango(diagonalMaior, diagonalMenor));
        
        
    }
    
}
