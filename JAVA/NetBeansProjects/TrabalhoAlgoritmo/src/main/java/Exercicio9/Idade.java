/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio9;

/**
 *
 * @author ccfel
 */
public class Idade {
    public int idadeAnos, idadeMeses, idadeDias;
    
    public Idade(int anoNascimento, int anoAtual){
        idadeAnos = anoAtual - anoNascimento;
        idadeMeses = idadeAnos*12;
        idadeDias = idadeAnos *365;
        
    
    }
    
    
}
