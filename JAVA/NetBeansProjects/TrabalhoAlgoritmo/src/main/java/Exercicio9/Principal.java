/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio9;

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
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o ano de nascimento: ");
        int anoNascimento = ler.nextInt();
        System.out.println("Digite o ano atual: ");
        int anoAtual = ler.nextInt();
        Idade idade = new Idade(anoNascimento, anoAtual);
        
        System.out.println("Idade em anos: " + idade.idadeAnos);
        System.out.println("Idade em meses: " + idade.idadeMeses);
        System.out.println("Idade em dias: " + idade.idadeDias);
        
        
        
    }
    
}
