package main.java.br.com.alura.leilao.service;

import java.time.LocalDate;

import main.java.br.com.alura.leilao.dao.PagamentoDao;
import main.java.br.com.alura.leilao.model.Lance;
import main.java.br.com.alura.leilao.model.Pagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GeradorDePagamento {

	@Autowired
	private PagamentoDao pagamentos;

	public void gerarPagamento(Lance lanceVencedor) {
		LocalDate vencimento = LocalDate.now().plusDays(1);
		Pagamento pagamento = new Pagamento(lanceVencedor, vencimento);
		this.pagamentos.salvar(pagamento);
	}

}
