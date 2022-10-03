package TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.service;
/*
O sistema deve permitir que os funcionários recebam um reajuste salarial anual baseado em seu desempenho, obedecendo às seguintes regras:

Se o desempenho for classificado como "A desejar", o reajuste será de 3% do salário atual.
Se o desempenho for "Bom,", o reajuste será de 15% do salário.
Se o desempenho for "Ótimo", o reajuste será de 20% do salário.
*/

import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Desempenho;
import TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTeste {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void instanciarReferenciaObjeto() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Geslon", LocalDate.now(), new BigDecimal(1000));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
        service.concederAjuste(funcionario, Desempenho.A_DESEJAR);
        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
        service.concederAjuste(funcionario, Desempenho.BOM);
        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
        service.concederAjuste(funcionario, Desempenho.OTIMO);
        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}

