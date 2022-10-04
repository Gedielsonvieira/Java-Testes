package javaTestesMock.main.java.br.com.alura.leilao;

import javaTestesMock.main.java.br.com.alura.leilao.dao.LeilaoDao;
import org.junit.jupiter.api.Test;

public class HelloWorldMockito {
    @Test
    public void hello() {
        LeilaoDao mock = Mockito.mock(LeilaoDao.class);//Cria em tempo de execução um mock que simula o comportamento da classe LeilaoDao

    }
}


