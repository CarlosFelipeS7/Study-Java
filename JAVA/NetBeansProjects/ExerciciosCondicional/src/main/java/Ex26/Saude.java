/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex26;

/**
 *
 * @author ccfel
 */
public class Saude {
    private int idade;
        public String Saude(int idade){
        
            this.idade=idade;
            double valor;
            
            if(idade<=10){
                valor = 30;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
        
            else if(idade>10 && idade<=29){
                valor=60;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
            
            else if(idade>29 && idade<=45){
                valor=120;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
            
            else if(idade>45 && idade<=59){
                valor=150;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
            
            else if(idade>59 && idade<=65){
                valor=250;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
            
              
            else if(idade>65){
                valor=400;
                System.out.println("Voce tem de idade: " + idade + " Deve pagar: " + valor);
            }
            
            return"";
        }
}
