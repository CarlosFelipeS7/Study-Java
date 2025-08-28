/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio10;

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
     
        System.out.println("Digite o raio da esfera: ");
        double raio = ler.nextDouble();
        
        Esfera esfera = new Esfera(raio);
        
        System.out.println("Comprimento da esfera " + esfera.calcularComprimento());
        System.out.println("Area da esfera " + esfera.calcularArea());
        System.out.println("Volume da esfera " + esfera.calcularVolume());
     
    }
    
}
