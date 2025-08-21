/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex15;

/**
 *
 * @author ccfel
 */
public class Ex15 {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int n1 = 1;
    int n2 = 0;
    for (int i = 0; n2 < 16; i+=n1) { 
        n1+=i;
        n2+=1;
        System.out.println(i);
        System.out.println(n1);
    }
    }
}