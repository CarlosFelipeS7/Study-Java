/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;
import java.util.Scanner;
/**
 *
 * @author ccfel
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //declaracao de variaveis
        int n1, n2, soma, subtracao, multiplicacao;
        float divisao, resto, raizQuadrada, potencia;
        
        //instancia objeto da classe scanner
        Scanner ler = new Scanner(System.in);
        
        //Entrada de dados 
        System.out.println("Entre com o 1 numero");
        n1 = ler.nextInt();
        System.out.println("Entre com o 2 numero");
        n2 = ler.nextInt();
        
        //Realizando o processamento de dados
        soma = n1+n2;
        subtracao = n1-n2;
        multiplicacao = n1*n2;
        divisao = n1/n2;
        resto = n1%n2;
        potencia = (float) Math.pow(n1,n2);
        raizQuadrada = (float) Math.sqrt(n1);
        
        System.out.println("Soma de n1 + n2 = " + soma);
        System.out.println("Subtracao de n1 - n2 = " + subtracao);
        System.out.println("Multiplicacao de n1 *  n2 = " + multiplicacao);
        System.out.println("Divisao de n1 / n2 = " + divisao);
        System.out.println("Resto da divisao de n1 / n2 = " + resto);
        System.out.println("Potencia de n1 elevado a n2 = " + potencia);
        System.out.println("Raiz Quadrada de n1 = " + raizQuadrada);
        
    }
    
}
