/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio2;

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
        Produto produto = new Produto();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o valor do produto: ");
        double preco = ler.nextDouble();
        
        System.out.println("O valor do produto com um desconto de 10% aplicado: " + produto.produto(preco));
        
        
    }
    
}
