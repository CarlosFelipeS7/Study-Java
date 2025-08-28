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
        Ferraduras ferraduras = new Ferraduras();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite a quantidade de cavalos: ");
        int qtdcavalos = ler.nextInt();
        
        System.out.println("A quantidade de ferraduras necessarias: " + ferraduras.ferraduras(qtdcavalos));
        
        
        
    }
    
}
