/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author ccfel
 */
public class Area {
    private double valor1, valor2, area;
    
    public double area(double valor1, double valor2){
        this.valor1=valor1;
        this.valor2=valor2;
        this.area=(this.valor1*this.valor2);
        return this.area;
    }
}
