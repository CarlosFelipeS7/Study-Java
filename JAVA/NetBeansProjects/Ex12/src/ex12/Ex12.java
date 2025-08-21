/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex12;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Ex12 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        System.out.println("Digite um valor: ");
        int n1 = ler.nextInt();
        
        for(int i = n1; i <=(n1 +10); i++){
            System.out.println(i);
        }
        
        
    }
    
}
