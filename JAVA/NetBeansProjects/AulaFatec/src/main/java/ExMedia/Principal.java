/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ExMedia;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Principal {

   
    
    
    public static void main(String[] args) {
         Media media = new Media();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Informe o primeiro numero: ");
        double valor1 = ler.nextDouble();
        System.out.println("Informe o segundo numero");
        double valor2 = ler.nextDouble();
        System.out.println("Informe o terceiro numero: ");
        double valor3 = ler.nextDouble();
        System.out.println("Informe o quarto numero");
        double valor4 = ler.nextDouble();
        
        
        
        System.out.println("O valor da media " + media.media(valor1, valor2, valor3, valor4));

        
        
        
    }
    
}
