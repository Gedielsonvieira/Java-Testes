package TestesAutomatizados;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTesteJUnit {

    @Test //adiciona o JUnit ao projeto e informa que o método de teste será executado pelo JUnit
    public void deveSomarDoisNumerosPositivos(){
        Calculadora calculo = new Calculadora();
        int soma = calculo.soma(5,5);

        // Com isso o JUnit irá verirficar se os valores são iguais - primeiro parâmetro é o valor esperado.
        Assertions.assertEquals(10,soma);
    }
}
