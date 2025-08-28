/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio7;

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
     Quadrado quadrado = new Quadrado();
     
        System.out.println("Digite o lado do quadrado");
        double lado = ler.nextDouble();
        
        System.out.println("Area do quadrado: " + quadrado.Quadrado(lado));
        
     
     
    }
    
}
