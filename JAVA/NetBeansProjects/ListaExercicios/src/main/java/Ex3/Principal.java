/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ex3;

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
        Gasolina gasolina = new Gasolina();
        Scanner ler = new Scanner(System.in);
        
        System.out.println("Digite o preco do litro da gasolina: ");
        double valorGasolina = ler.nextDouble();
        
        System.out.println("Digite o valor de pagamento: ");
        double valorTotal = ler.nextDouble();
        
        System.out.println("Voce abasteceu: " + gasolina.gasolina(valorGasolina, valorTotal) + "litros");
    }
    
}
