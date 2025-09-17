/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex22;

import javax.swing.JOptionPane;



/**
 *
 * @author ccfel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       Credito credito = new Credito();
       
       
       
       
        double saldo = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Informe o saldo medio:", "Saldo", JOptionPane.QUESTION_MESSAGE)
       );
       
       
        
        System.out.println(credito.credito(saldo));
    }
    
}
