/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Exercicio10;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Esfera {
    private double raio;
    private static final double PI = Math.PI;

    public Esfera(double raio) {
        this.raio = raio;
    }

    public double calcularComprimento() {
        return 2 * PI * raio;
    }

    public double calcularArea() {
        return PI * raio * raio;
    }

    public double calcularVolume() {
        return (3.0 / 4.0) * PI * Math.pow(raio, 3);
    }
}

