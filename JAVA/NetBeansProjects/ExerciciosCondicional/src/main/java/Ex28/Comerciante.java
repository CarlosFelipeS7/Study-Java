/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex28;

/**
 *
 * @author ccfel
 */
public class Comerciante {
    
    private double valor;
    
        public String Comerciante (double valor) {

            this.valor=valor;
     
            
            if(valor<10.00){
               double lucro = 0.7;
               
               double multi = valor * lucro;
               
                double total = valor + multi;
                
                System.out.println("Produto inferior a 10 reais, com o lucro de 70% aplicado: " + total);
            }
            
            else if(valor >10.00 && valor<30.00){
               double lucro = 0.5;
                
                double multi = valor * lucro;
               
                double total = valor + multi;
                
                System.out.println("Produto inferior a 30 reais, com o lucro de 50% aplicado: " + total);
            }
            
              else if(valor >30.00 && valor<50.00){
               double lucro = 0.4;
                
                double multi = valor * lucro;
               
                double total = valor + multi;
                
                System.out.println("Produto inferior a 50 reais, com o lucro de 40% aplicado: " + total);
            }
            
               else if(valor >50.00){
               double lucro = 0.3;
                
                double multi = valor * lucro;
               
                double total = valor + multi;
                
                System.out.println("Produto superior a 50 reais, com o lucro de 30% aplicado: " + total);
            }
            
               else{
                   System.out.println("Opcao invalida");
               }
            
            
            return "";
}
    
}
