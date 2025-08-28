/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio1;

/**
 *
 * @author ccfel
 */
public class Notas {
    private double nota1, nota2, media, media2;
    
    public double notas(double nota1, double nota2){
    this.nota1 = nota1;
    this.nota2 = nota2;
   
    
    media = ((nota1*2) + (nota2*3));
    media2 = (media/5);
    return media2;
    
    
    }
    
}
