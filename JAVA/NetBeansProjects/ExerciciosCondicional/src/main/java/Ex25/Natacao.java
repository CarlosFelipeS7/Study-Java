/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex25;

/**
 *
 * @author ccfel
 */
public class Natacao {
       private int idade;
        public String natacao(int idade){
       
            this.idade=idade;
            
            if(idade>=5 && idade<=7){
                System.out.println("Infantil A: " + idade);
            }
        
            else if(idade>=8 && idade<=10){
                System.out.println("Infantil B: " + idade);
            }
            
             else if(idade>=11 && idade<=13){
                System.out.println("Juvenil A: " + idade);
            }
            
             else if(idade>=14 && idade<=17){
                System.out.println("Juvenil B: " + idade);
            }
            
            else if(idade>=18){
                System.out.println("Senior: " + idade);
            }
            
            return "";
            
        }
}
