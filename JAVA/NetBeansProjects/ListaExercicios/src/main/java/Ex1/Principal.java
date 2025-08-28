/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex1;

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
        Area area = new Area();
        
        Scanner ler = new Scanner(System.in);
        
        
        System.out.println("Digite o comprimento do terreno: ");
        double valor1 = ler.nextDouble();   
        System.out.println("Digite a largura do terreno: ");
        double valor2 = ler.nextDouble();
        System.out.println("A area do terreno: " + area.area(valor1, valor2));
        
        
    }
    
}
