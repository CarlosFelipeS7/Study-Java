/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex27;

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
     
      
      Notas notas = new Notas();
      
      double nota1 = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite a primeira nota:", "Nota", JOptionPane.QUESTION_MESSAGE)
       );
         
       double nota2 = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite a segunda nota:", "Nota", JOptionPane.QUESTION_MESSAGE)
       );
      
        System.out.println(notas.notas(nota1, nota2));
    }
    
}
