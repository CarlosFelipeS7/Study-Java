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
       
        Maior maior = new Maior();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite sua idade: ");
       int idade = ler.nextInt();
        
        System.out.println(maior.Maior(idade));
        
        
    }
    
}
