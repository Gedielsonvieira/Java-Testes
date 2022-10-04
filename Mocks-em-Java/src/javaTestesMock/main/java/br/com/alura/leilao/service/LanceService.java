package javaTestesMock.main.java.br.com.alura.leilao.service;

import javaTestesMock.main.java.br.com.alura.leilao.dao.LanceDao;
import javaTestesMock.main.java.br.com.alura.leilao.dao.LeilaoDao;
import javaTestesMock.main.java.br.com.alura.leilao.dao.UsuarioDao;
import javaTestesMock.main.java.br.com.alura.leilao.dto.NovoLanceDto;
import javaTestesMock.main.java.br.com.alura.leilao.model.Lance;
import javaTestesMock.main.java.br.com.alura.leilao.model.Leilao;
import javaTestesMock.main.java.br.com.alura.leilao.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanceService {

	@Autowired
	private LanceDao lances;

	@Autowired
	private UsuarioDao usuarios;

	@Autowired
	private LeilaoDao leiloes;

	public boolean propoeLance(NovoLanceDto lanceDto, String nomeUsuario) {

		Usuario usuario = usuarios.buscarPorUsername(nomeUsuario);
		Lance lance = lanceDto.toLance(usuario);

		Leilao leilao = this.getLeilao(lanceDto.getLeilaoId());

		if (leilao.propoe(lance)) {
			lances.salvar(lance);
			return true;
		}

		return false;
	}

	public Leilao getLeilao(Long leilaoId) {
		return leiloes.buscarPorId(leilaoId);
	}

}