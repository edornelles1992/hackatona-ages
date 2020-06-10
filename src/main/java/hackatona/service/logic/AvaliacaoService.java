package hackatona.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AvaliacaoDao;
import hackatona.dao.TimeDao;
import hackatona.dao.UserDao;
import hackatona.dto.AvaliacaoDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.model.Avaliacao;
import hackatona.model.Time;
import hackatona.model.User;
import hackatona.utility.ValidationUtils;

@Service
public class AvaliacaoService extends AbstractService {

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private TimeDao timeDao;

	/**
	 * abrir avaliação para um usuário (avaliador) poder realizar.
	 * 
	 * @param idTime
	 * @param idUsuario
	 * @return HttpResponseDTO
	 */
	public HttpResponseDTO criarAvaliacao(Integer idTime, Integer idUsuario) {
		this.LogServiceConsumed(this.getClassName(), "criarAvaliacao");
		if (idTime == null || idUsuario == null)
			HttpResponseDTO.fail("Time ou Avaliador inválido!");

		Time time = this.timeDao.findById(idTime).get();
		User usuario = this.userDao.findById(idUsuario).get();

		if (time == null || usuario == null)
			HttpResponseDTO.fail("Time ou avaliador não encontrado.");
		if (this.avaliacaoDao.findByUserAndTime(usuario, time) != null)
			HttpResponseDTO.fail("Avaliação já existente!");

		Avaliacao avaliacao = new Avaliacao(usuario, time);
		this.avaliacaoDao.save(avaliacao);
		return HttpResponseDTO.success("Avaliação criada com sucesso!");
	}

	public HttpResponseDTO efetuarAvaliacao(AvaliacaoDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "efetuarAvaliacao");
		String erro = ValidationUtils.validarAvaliacao(dto);
		if (erro != null)
			HttpResponseDTO.fail(erro);
		
		this.avaliacaoDao.save(mapper.map(dto, Avaliacao.class));
		return HttpResponseDTO.success("Avaliação realizada com sucesso!");
	}

	public HttpResponseDTO buscarAvaliacao(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "buscarAvaliacao");
		return HttpResponseDTO.success(mapper.map(this.avaliacaoDao.findById(id).get(), AvaliacaoDTO.class));
	}

	public HttpResponseDTO listarAvaliacoes() {
		this.LogServiceConsumed(this.getClassName(), "listarAvaliacoes");
		return HttpResponseDTO.success(mapper.mapAll( this.avaliacaoDao.findAll(), AvaliacaoDTO.class));
	}
	
	public HttpResponseDTO listarAvaliacoesPorAvaliador(Integer idUsuario) {
		this.LogServiceConsumed(this.getClassName(), "listarAvaliacoesPorAvaliador");
		User usuario = userDao.findById(idUsuario).get();
		return HttpResponseDTO.success(mapper.mapAll(this.avaliacaoDao.findByUser(usuario), AvaliacaoDTO.class));
	}

}
