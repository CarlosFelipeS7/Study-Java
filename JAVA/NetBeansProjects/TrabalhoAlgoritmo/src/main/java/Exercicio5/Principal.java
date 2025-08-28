/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio5;

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
        Gramas gramas = new Gramas();
        
        System.out.println("Digite seu peso: ");
        double peso = ler.nextDouble();
        
        System.out.println("Seu peso em gramas: " + gramas.gramas(peso));
        
    }
    
}
