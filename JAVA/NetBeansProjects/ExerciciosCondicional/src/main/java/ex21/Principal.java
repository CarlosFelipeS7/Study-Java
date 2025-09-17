/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ex21;


import javax.swing.JOptionPane;


//coletar texto
//String nome = JOptionPane.showInputDialog(null, "Seu nome:", "Titulo", JOptionPane.QUESTION_MESSAGE);

//int resposta = JOptionPae.showConfirmDialog(null, "Dseja sair", "Confirmacao", JOptionPane.YES_O_OPTION);

//exibir mensagens com um botao OK
//JOptionPane.showMessageDialog(null, "Ola mundo", "Titulo", JOptionPane.INFORMATION_MESSAGE); 
//1 null: para centralizar janela
//2 mensagem a ser exibida
//3 titulo da janela
//4 tipo de mensagem

/**
 *
 * @author ccfel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       IMC imc = new IMC();
      
       double altura = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite sua altura:", "Altura", JOptionPane.QUESTION_MESSAGE)
       );
       
        double peso = Double.parseDouble(
       
                JOptionPane.showInputDialog(null, "Digite seu peso:", "Peso", JOptionPane.QUESTION_MESSAGE)
       );
       
      
              
        
        System.out.println("Seu IMC: " + imc.imc(peso, altura));
       
    }
    
}
