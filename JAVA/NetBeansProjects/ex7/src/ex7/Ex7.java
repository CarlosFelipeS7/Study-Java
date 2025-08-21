/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex7;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Ex7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        int a; int b; int n3;
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o primeiro valor");
        a = ler.nextInt();
        
         System.out.println("Digite o segundo valor");
        b = ler.nextInt();
        
        if( a%2 == 0 && b%2 ==0){
            n3 = a+b;
            System.out.println("A soma dos dois valores: " +n3);
        }
        else{
            System.out.println("Os dois valores devem ser pares");}
    }
    
}
