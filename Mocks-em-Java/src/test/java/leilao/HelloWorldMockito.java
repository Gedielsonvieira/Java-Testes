package test.java.leilao;

import br.com.alura.leilao.dao.LeilaoDao;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;


public class HelloWorldMockito {
    @Test
    public void hello() {
        LeilaoDao mock = Mockito.mock(LeilaoDao.class);//Cria em tempo de execução um mock que simula o comportamento da classe LeilaoDao
        List todos = mock.buscarTodos();
        Assert.assertTrue(todos.isEmpty());
    }
}


