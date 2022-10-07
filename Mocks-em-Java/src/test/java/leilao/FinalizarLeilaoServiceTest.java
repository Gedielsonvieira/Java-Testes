package leilao;

import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.service.FinalizarLeilaoService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import br.com.alura.leilao.dao.LeilaoDao;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import main.java.br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.model.Lance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FinalizarLeilaoServiceTest {

    private FinalizarLeilaoService service;

    @Mock
    private LeilaoDao leilaoDao;

    /* Mocamos leilaoDao porque queremos fazer um teste unitário e como leilaoDao faz as queries no BD
    e queremos focar somente no comportamento dos métodos o mock vai simular essa classe, assim conseguimos focar somente no comportamento, lógica */
    @BeforeEach
    public void BeforeEach() {
        MockitoAnnotations.initMocks(this);
        this.service = new FinalizarLeilaoService(leilaoDao);//passando um mock para uma classe via construtor
    }

    @Test
    void deveriaFinalizarUmLeilao() {
        List<Leilao> leiloes = leiloes();

        Mockito.when(leilaoDao.buscarLeiloesExpirados()).thenReturn(leiloes);

        service.finalizarLeiloesExpirados();

        Leilao leilao = leiloes.get(0);
        Assert.assertTrue(leilao.isFechado());
        Assert.assertEquals(new BigDecimal("900"), leilao.getLanceVencedor().getValor());

        Mockito.verify(leilaoDao).salvar(leilao);
    }

    private List<Leilao> leiloes() {
        List<Leilao> lista = new ArrayList<>();

        Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));

        Lance primeiro = new Lance(new Usuario("Beltrano"), new BigDecimal("600"));
        Lance segundo = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

        leilao.propoe(primeiro);
        leilao.propoe(segundo);

        lista.add(leilao);

        return lista;
    }
}
