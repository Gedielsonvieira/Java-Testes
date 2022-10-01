package TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.service;

import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

class BonusServiceTest {
    @Test
    public void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gedielson", LocalDate.now(),new BigDecimal("20000")));
        Assertions.assertEquals(new BigDecimal("0"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaFuncionarioComSalarioBaixo() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gedielson", LocalDate.now(),new BigDecimal("1000")));
        Assertions.assertEquals(new BigDecimal("100.0"), bonus);
    }

    @Test
    public void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Gedielson", LocalDate.now(),new BigDecimal("10000")));
        Assertions.assertEquals(new BigDecimal("1000.0"), bonus);
    }
}