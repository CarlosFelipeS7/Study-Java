/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex8;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Ex8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
        Scanner ler = new Scanner(System.in);
      
        int n2 = ler.nextInt();
      
        int n3 = 0;
        
        
       
        for(int i =1; i<10; i++){
          
            int n1 = ler.nextInt();
            n2 += n1;
            
            
            }
            n3 = n2/10;
            
            System.out.println(n3);
  
        
        
        
        
        
    }
    
}
