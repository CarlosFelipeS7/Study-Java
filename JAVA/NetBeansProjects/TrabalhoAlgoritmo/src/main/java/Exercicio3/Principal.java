/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio3;

import java.util.Scanner;

/**
 *
 * @author ccfel
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Salario salario = new Salario();
       Scanner ler = new Scanner(System.in);
       
        System.out.println("Digite o seu salario: ");
        double pagamento = ler.nextDouble();
        System.out.println("Digite o valor total das vendas realizadas: ");
        double vendas = ler.nextDouble();
        
        System.out.println("O salario final: " + salario.salario(pagamento, vendas));
        
    }
    
}
