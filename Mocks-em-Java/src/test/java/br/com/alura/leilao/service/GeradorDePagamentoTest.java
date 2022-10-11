package br.com.alura.leilao.service;

import br.com.alura.leilao.dao.PagamentoDao;
import br.com.alura.leilao.model.Lance;
import br.com.alura.leilao.model.Leilao;
import br.com.alura.leilao.model.Pagamento;
import br.com.alura.leilao.model.Usuario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.math.BigDecimal;
import java.time.LocalDate;

class GeradorDePagamentoTest {

    private GeradorDePagamento gerador;

    @Mock
    private PagamentoDao pagamentoDao;

    @Captor// utilizamos captor para capturar um objeto que foi passado por um método de um Mock.
    private ArgumentCaptor<Pagamento> captor;


    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
        this.gerador = new GeradorDePagamento(pagamentoDao);
    }

    @Test
    void deveriaCriarPagamentoParaVencedorDoLeilao() {
        Leilao leilao = leilao();
        Lance lanceVencedor = leilao.getLanceVencedor();
        gerador.gerarPagamento(lanceVencedor);
        Mockito.verify(pagamentoDao).salvar(captor.capture());

        Pagamento pagamento = captor.getValue();//captor.getValue() devolve o objeto que foi capturado na linha anterior com captor.capture()
        Assertions.assertEquals(LocalDate.now().plusDays(1), pagamento.getVencimento());

        Assertions.assertEquals(lanceVencedor.getValor(), pagamento.getValor());

        Assertions.assertEquals(lanceVencedor.getUsuario().getNome(), pagamento.getUsuario().getNome());

        Assertions.assertEquals(leilao, pagamento.getLeilao());

        Assertions.assertFalse(pagamento.getPago());
    }

    private Leilao leilao() {

        Leilao leilao = new Leilao("Celular", new BigDecimal("500"), new Usuario("Fulano"));

        Lance lance = new Lance(new Usuario("Ciclano"), new BigDecimal("900"));

        leilao.propoe(lance);
        leilao.setLanceVencedor(lance);

        return leilao;
    }

}