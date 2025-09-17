/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex27;

/**
 *
 * @author ccfel
 */
public class Notas {
    private double nota1, nota2;

    
        public String notas (double nota1, double nota2){
            this.nota1=nota1;
            this.nota2=nota2;
           
            
            
            double media = (nota1 + nota2) /2;
            
            if(media>=7){
                System.out.println("Aprovado com nota: " + media);
            }
            
           else if(media<3){
                System.out.println("Reprovado com nota: " + media);
            }
            
           else{
                System.out.println("Esta em exame");
           }
        
        return"";
        
        }
}
