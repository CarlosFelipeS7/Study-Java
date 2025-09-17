/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex23;


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
    
        Idade idade = new Idade();
        
        
           double idad = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite sua idade:", "Idade", JOptionPane.QUESTION_MESSAGE)
       );
        
       
        
        System.out.println(idade.idade((int) idad));
        
    }
    
}
