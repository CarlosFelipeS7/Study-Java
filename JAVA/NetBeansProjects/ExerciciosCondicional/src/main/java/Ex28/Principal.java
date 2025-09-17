/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex28;

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
      
       Comerciante comerciante = new Comerciante();
       
       
        double valor = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite o valor do produto:", "Produto", JOptionPane.QUESTION_MESSAGE)
       );
        
        System.out.println(comerciante.Comerciante(valor));
       
    }
    
}
