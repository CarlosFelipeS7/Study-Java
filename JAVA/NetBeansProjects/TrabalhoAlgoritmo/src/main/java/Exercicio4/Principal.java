/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Exercicio4;

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
        Peso peso = new Peso();
        PesoVinte pesovinte = new PesoVinte();
        
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite seu peso: ");
        double kg = ler.nextDouble();
        
        System.out.println("Qual a porcentagem que voce engordou ? 15 ou 20?");
        double escolha = ler.nextDouble();
        
        if(escolha == 15){
            System.out.println("Voce esta com: " + peso.peso(kg));
        }
        else if(escolha ==20){
            System.out.println("Voce esta com: " + pesovinte.pesovinte(kg));
        }
        else{
            System.out.println("Opcao Invalida");
        }
        
    }
    
}
