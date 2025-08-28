/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex3;

/**
 *
 * @author ccfel
 */
public class Gasolina {
    private double valorGasolina, valorTotal;
    
    public double gasolina(double valorGasolina, double valorTotal){
    
        this.valorGasolina=valorGasolina;
        this.valorTotal=valorTotal;
       double qtdLitros=(valorTotal/valorGasolina);
        return qtdLitros;
        
       
        
    }
}
