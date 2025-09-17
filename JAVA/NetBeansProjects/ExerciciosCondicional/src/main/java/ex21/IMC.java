/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex21;

/**
 *
 * @author ccfel
 */
public class IMC {
    
    private double peso, altura;
    
    public String imc(double peso, double altura){
    
        this.peso = peso;
        this.altura = altura;
        double quadrado = altura *altura;
        double imc = peso/quadrado;
        
        if(imc<20){
            System.out.println("IMC abaixo do peso: " + imc);
        }
        else if(imc>=20 && imc<25){
            System.out.println("IMC normal : " + imc);
        }
         else if(imc>=25 && imc<30){
            System.out.println("IMC sobrepeso : " + imc);
        }
         else if(imc>=30 && imc<40){
            System.out.println("IMC obeso : " + imc);
        }
         else if(imc>=40){
            System.out.println("IMC obeso morbido : " + imc);
        }
        
        
        
        
        
        
        return "";
        
        
        
    }
    
    
}
