/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ExSoma;

import java.util.Scanner;


public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Soma soma = new Soma();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Informe o primeiro numero: ");
        int valor1 = ler.nextInt();
        System.out.println("Informe o segundo numero");
        int valor2 = ler.nextInt();
        System.out.println("O valor da soma " + soma.soma(valor1, valor2));


    }
    
}
