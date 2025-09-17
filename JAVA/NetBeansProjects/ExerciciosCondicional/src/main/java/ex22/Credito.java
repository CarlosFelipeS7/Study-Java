/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ex22;

/**
 *
 * @author ccfel
 */
public class Credito {
    private double saldo;
    
    public String credito (double saldo){
    
        this.saldo = saldo;
    
        if(saldo<501){
            System.out.println("Nenhum credito");
        }
        
        else if(saldo>=501 && saldo <1000){
            double credito = saldo *0.3;
            double total = credito + saldo;
            System.out.println("Saldo inicial :" +saldo);
            System.out.println("30% do saldo: " + credito);
            System.out.println("Saldo apos o percentual: " + total );
        }
        
         else if(saldo>=1000 && saldo <3000){
            double credito = saldo *0.4;
             double total = credito + saldo;
            System.out.println("Saldo inicial :" +saldo);
            System.out.println("40% do saldo: " + credito);
             System.out.println("Saldo apos o percentual: " + total );
        }
        
          else if(saldo <3001){
            double credito = saldo *0.5;
             double total = credito + saldo;
            System.out.println("Saldo inicial :" +saldo);
            System.out.println("50% do saldo: " + credito);
             System.out.println("Saldo apos o percentual: " + total );
        }
        
        return "";
    }
}
