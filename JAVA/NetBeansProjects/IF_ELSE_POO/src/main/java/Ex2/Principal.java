/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex2;

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
        Eleitor eleitor = new Eleitor();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite sua idade: ");
        int idade = ler.nextInt();
        
        System.out.println(eleitor.eleitor(idade));
        
        
    }
    
}
