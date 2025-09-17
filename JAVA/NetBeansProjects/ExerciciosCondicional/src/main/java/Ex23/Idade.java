/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex23;

/**
 *
 * @author ccfel
 */
public class Idade {
    
    private int idade;
        public String idade(int idade){
            
           this.idade=idade;
           
           if(idade<18){
               System.out.println("Menor de idade: " + idade);
           }
            
           else if(idade>18&& idade<65){
           
               System.out.println("Maior de idade: " + idade);
           
           }
            
              
           else if(idade>=65){
           
               System.out.println("Idoso: " + idade);
           
           }
return "";
        }
        
    
}
