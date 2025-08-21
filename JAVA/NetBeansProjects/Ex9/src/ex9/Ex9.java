/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex9;


import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Ex9 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner ler = new Scanner(System.in);
        
        
       
        int n1;
        int n2 = 0;
        
       
       for(int i =1; i<=20; i++){
           System.out.println("Digite outro numero");
            n1 = ler.nextInt();
            
       
            if(n1>n2){
            n2 = n1;
            }
                 
       }
      
     System.out.println("Maior valor " + n2);
       
    }
    
}
