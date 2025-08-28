/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex6;

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
       Granja granja = new Granja();
       Scanner ler = new Scanner(System.in);
       
        System.out.println("Digite a quantidade de galinhas: ");
       int qtdGalinhas = ler.nextInt();
       
        System.out.println("O valor total gasto com os frangos: " + granja.granja(qtdGalinhas));
       
       
    }
    
}
