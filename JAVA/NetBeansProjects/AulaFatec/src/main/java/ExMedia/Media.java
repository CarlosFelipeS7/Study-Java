/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ExMedia;

/**
 *
 * @author ccfel
 */
public class Media {
    private double valor1, valor2, valor3, valor4, media;
    
    
    public double media (double valor1, double valor2, double valor3, double valor4){
    
        this.valor1=valor1;
        this.valor2=valor2;
        this.valor3=valor3;
        this.valor4=valor4;
        this.media=((valor1+valor2+valor3+valor4)/4);
       
        return this.media;
    }
    
    
}
