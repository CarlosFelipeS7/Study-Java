/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ex2;

/**
 *
 * @author ccfel
 */
public class Eleitor {
    
    private int idade;
    
    public String eleitor(int idade){
    this.idade=idade;
    
    if(idade<16){
        System.out.println("Nao eleitor, abaixo de 16 anos");
    }
      
    else if(idade >17 && idade <65){
        System.out.println("Eleitor obrigatorio");
    }
    
    else if(idade >15 && idade<18){
        System.out.println("Eleitor facultativo");
    }
    
    return "";
    
}}
