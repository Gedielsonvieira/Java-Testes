package javaTestesMock.main.java.br.com.alura.leilao.service;

import java.util.List;

import javaTestesMock.main.java.br.com.alura.leilao.dao.LeilaoDao;
import javaTestesMock.main.java.br.com.alura.leilao.model.Lance;
import javaTestesMock.main.java.br.com.alura.leilao.model.Leilao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalizarLeilaoService {

	@Autowired
	private LeilaoDao leiloes;

	public void finalizarLeiloesExpirados() {
		List<Leilao> expirados = leiloes.buscarLeiloesExpirados();
		expirados.forEach(leilao -> {
			Lance maiorLance = maiorLanceDadoNoLeilao(leilao);
			leilao.setLanceVencedor(maiorLance);
			leilao.fechar();
			leiloes.salvar(leilao);
		});
	}

	private Lance maiorLanceDadoNoLeilao(Leilao leilao) {
		List<Lance> lancesDoLeilao = leilao.getLances();
		lancesDoLeilao.sort((lance1, lance2) -> {
			return lance2.getValor().compareTo(lance1.getValor());
		});
		return lancesDoLeilao.get(0);
	}
	
}
