/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex1;

/**
 *
 * @author ccfel
 */
public class Maior {
    
    private int idade;
    
    public String Maior(int idade){
        this.idade=idade;
        
        if(idade<18){
            System.out.println("Voce e menor de idade, pois tem: " + idade);
      
        }
        
        else if(idade>=18){
            System.out.println("Voce e maior de idade, pois tem : " + idade);
    
        }
       
        else if(idade>=65){
            System.out.println("Voce e idoso, pois tem: " + idade);
           
        }
    
        else{
            System.out.println("Idade invalida");
            
        }
        return "";

    }
    
    
    
    
}
