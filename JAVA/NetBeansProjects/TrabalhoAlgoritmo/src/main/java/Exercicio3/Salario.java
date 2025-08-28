/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio3;

/**
 *
 * @author ccfel
 */
public class Salario {
    private double salario, vendas;
    
    public double salario(double salario, double vendas){
        this.salario = salario;
        this.vendas = vendas;
    
        double comissao = (vendas*0.04);
        
        return salario + comissao;
        
    }
}
