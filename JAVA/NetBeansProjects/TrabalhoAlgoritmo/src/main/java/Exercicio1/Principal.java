/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio1;

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
        Notas notas = new Notas();
        Scanner ler = new Scanner(System.in); 
        
        System.out.println("Digite a primeira nota: ");
        double nota1 = ler.nextDouble();
        
         System.out.println("Digite a segunda nota: ");
        double nota2 = ler.nextDouble();
        
        
        
        System.out.println("A media ponderada: " + notas.notas(nota1, nota2));
    }
    
}
