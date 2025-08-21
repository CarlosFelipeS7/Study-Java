/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex14;

/**
 *
 * @author ccfel
 */
public class Ex14 {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        
        float s;
        int a,b,c;
        a = 37;
        b = 38;
        c = 1;
        s = 0;
        while(c <= 37){
            s = s + ((a * b)/c);
            a -=1;
            b -=1;
            c +=1;
        }
        System.out.println("O valor de S: " + s);

    }
}

                
        
        
