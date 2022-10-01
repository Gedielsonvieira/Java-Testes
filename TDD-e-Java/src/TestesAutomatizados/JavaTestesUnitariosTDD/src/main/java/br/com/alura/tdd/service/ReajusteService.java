package TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.service;

import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Desempenho;
import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class ReajusteService {

    public void concederAjuste(Funcionario funcionario, Desempenho desempenho) {
          //Com if else
//        if (desempenho == Desempenho.A_DESEJAR) {
//            BigDecimal ajusteSalarial = funcionario.getSalario().multiply(new BigDecimal("0.03"));
//            funcionario.ajustarSalario(ajusteSalarial);
//        }else if(desempenho == Desempenho.BOM){
//            BigDecimal ajusteSalarial = funcionario.getSalario().multiply(new BigDecimal("0.15"));
//            funcionario.ajustarSalario(ajusteSalarial);
//        }else{
//            BigDecimal ajusteSalarial = funcionario.getSalario().multiply(new BigDecimal("0.2"));
//            funcionario.ajustarSalario(ajusteSalarial);
//        }

        // Técnica de refatoração strategy
        BigDecimal percentagem = desempenho.percentualReajuste();
        BigDecimal ajusteSalarial = funcionario.getSalario().multiply(percentagem);
        funcionario.ajustarSalario(ajusteSalarial);
    }
}
