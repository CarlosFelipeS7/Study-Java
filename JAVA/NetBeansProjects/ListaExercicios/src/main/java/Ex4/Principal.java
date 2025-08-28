/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex4;

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
        Quilos quilos = new Quilos();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o peso do prato montado: ");
        double kgprato = ler.nextDouble();
        
        System.out.println("O valor a pagar: " + quilos.quilos(kgprato, kgprato));
        
        
    }
    
}
