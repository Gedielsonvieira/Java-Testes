package TestesAutomatizados;

import TestesAutomatizados.Calculadora;

public class CalculadoraTeste {
    public static void main(String[] args) {
        Calculadora calculo = new Calculadora();
        System.out.println(calculo.soma(3,7));
        System.out.println(calculo.soma(3,0));
        System.out.println(calculo.soma(0,0));
        System.out.println(calculo.soma(3,-2));
    }
}
