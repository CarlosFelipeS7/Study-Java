/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex24;


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
     
       Eleitor eleitor = new Eleitor();
       
           int idade = Integer.parseInt(
       
                JOptionPane.showInputDialog(null, "Digite sua idade:", "Idade", JOptionPane.QUESTION_MESSAGE)
       );
        
        System.out.println(eleitor.eleitor(idade));
       
    }
    
}
