/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio6;

/**
 *
 * @author ccfel
 */
public class Trapezio {
    private double baseMaior;
    private double baseMenor;
    private double altura;
    
    public double Trapezio(double baseMaior, double baseMenor, double altura){
    this.baseMaior=baseMaior;
    this.baseMenor = baseMenor;
    this.altura = altura;
    
    return (baseMaior + baseMenor) * altura /2;
        
        
    }
    
}
