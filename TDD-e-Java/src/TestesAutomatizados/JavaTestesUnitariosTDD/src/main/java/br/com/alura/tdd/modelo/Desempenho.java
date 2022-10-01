package TestesAutomatizados.JavaTestesUnitariosTDD.src.main.java.br.com.alura.tdd.modelo;

import java.math.BigDecimal;

public enum Desempenho {
    A_DESEJAR{
        @Override
        public BigDecimal percentualReajuste(){
            return new BigDecimal("0.03");
        }
    },
    BOM {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.15");
        }
    },
    OTIMO {
        @Override
        public BigDecimal percentualReajuste() {
            return new BigDecimal("0.2");
        }
    };
    //Quando o método é abstrato cada constante é obrigada a fornecer uma implementação
    public abstract BigDecimal percentualReajuste();
}
