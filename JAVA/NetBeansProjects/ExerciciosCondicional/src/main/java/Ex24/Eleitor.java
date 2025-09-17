/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex24;

/**
 *
 * @author ccfel
 */
public class Eleitor {
    private int idade;
            public String eleitor(int idade){
                this.idade=idade;
                
              if(idade<16){
                  System.out.println("Nao eleitor: " + idade);
              }
               
              else if(idade>=16 && idade<18){
                  System.out.println("Eleitor facultativo: " + idade);
              }

              else if(idade>=18 && idade<65){
                  System.out.println("Eleitor obrigatorio: " + idade);
              }
              
               else if(idade>65){
                  System.out.println("Eleitor facultativo: " + idade);
              }
            
            
            return "";
            }          
}
