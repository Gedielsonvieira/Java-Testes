package TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.service;

import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Funcionario;

import java.math.BigDecimal;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			System.out.println("Retorno do método compareTo: " + valor.compareTo(new BigDecimal("1000")));
			valor = BigDecimal.ZERO;
		}
		System.out.println("Bonus recebido: " + valor );
		return valor;
	}

}
