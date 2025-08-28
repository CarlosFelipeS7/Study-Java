/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio2;

/**
 *
 * @author ccfel
 */
public class Produto {
    private double preco;
    
    public double produto(double preco){
       
       this.preco=preco;
   
       
       double desconto = (preco*0.10);
       
       return (preco-desconto);
       


}}
