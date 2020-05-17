package hackatona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AvaliacaoDao;
import hackatona.dto.AvaliacaoDTO;
import hackatona.dto.HttpResponseDTO;

@Service
public class AvaliacaoService extends AbstractService {
	
	@Autowired
	private AvaliacaoDao avaliacaoDao;

	public HttpResponseDTO criarAvaliacao(Long idTime, Long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO efetuarAvaliacao(AvaliacaoDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO buscarAvaliacao(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO listarAvaliacoes(Long id) {
		//recebe o id para saber se tem que listar tudo (admin) ou somente os disponiveis ao usuario (avaliador)
		// TODO Auto-generated method stub
		return null;
	}

}
