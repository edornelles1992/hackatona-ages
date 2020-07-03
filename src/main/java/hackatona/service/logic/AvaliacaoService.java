package hackatona.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AvaliacaoDao;
import hackatona.dao.TimeDao;
import hackatona.dao.UserDao;
import hackatona.dto.AvaliacaoDTO;
import hackatona.dto.AvaliadorDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.model.Avaliacao;
import hackatona.model.Time;
import hackatona.model.User;
import hackatona.utility.ObjectMapperUtils;
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

	public HttpResponseDTO efetuarAvaliacao(Integer idUsuario, AvaliacaoDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "efetuarAvaliacao");
		
		if (this.userDao.findById(idUsuario).get().getPerfil() != 2) {
			return HttpResponseDTO.fail("Você não possui permissão para fazer uma avaliação.");
		}
				
		String erro = ValidationUtils.validarAvaliacao(dto);
		if (erro != null)
			HttpResponseDTO.fail(erro);
		Avaliacao avaliacao = this.avaliacaoDao.findById(dto.getId()).get();
		avaliacao.setInovacao(dto.getInovacao());
		avaliacao.setPitch(dto.getPitch());
		avaliacao.setProcesso(dto.getProcesso());
		avaliacao.setSoftware(dto.getSoftware());
		this.avaliacaoDao.save(avaliacao);
		return HttpResponseDTO.success("Avaliação realizada com sucesso!");
	}

	public HttpResponseDTO buscarAvaliacao(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "buscarAvaliacao");
		Avaliacao aval = this.avaliacaoDao.findById(id).get();
		AvaliacaoDTO dto = ObjectMapperUtils.getInstancia().map(aval, AvaliacaoDTO.class);
		dto.setAvaliador(new AvaliadorDTO(aval.getUser().getId(), aval.getUser().getNome()));
		return HttpResponseDTO.success(dto);
	}

	public HttpResponseDTO listarAvaliacoes() {
		this.LogServiceConsumed(this.getClassName(), "listarAvaliacoes");
		List<Avaliacao> avcs = this.avaliacaoDao.findAll();
		List<AvaliacaoDTO> dtos = ObjectMapperUtils.getInstancia().mapAll(avcs, AvaliacaoDTO.class);
		mapearAvaliador(avcs, dtos);
		return HttpResponseDTO.success("list", dtos);
	}
	
	public HttpResponseDTO listarAvaliacoesPorAvaliador(Integer idUsuario) {
		this.LogServiceConsumed(this.getClassName(), "listarAvaliacoesPorAvaliador");
		User usuario = userDao.findById(idUsuario).get();
		List<Avaliacao> avcs = this.avaliacaoDao.findByUser(usuario);
		List<AvaliacaoDTO> dtos = ObjectMapperUtils.getInstancia().mapAll(avcs, AvaliacaoDTO.class);
		mapearAvaliador(avcs, dtos);
		return HttpResponseDTO.success("list", dtos);
	}

	public HttpResponseDTO excluirAvaliacao(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "excluirTime");
		try {
			this.avaliacaoDao.deleteById(id);
			return HttpResponseDTO.success("Avaliação removida com sucesso!");
		} catch (Exception e) {
			return HttpResponseDTO.fail(e.getMessage());
		}
	}

	private void mapearAvaliador(List<Avaliacao> avcs, List<AvaliacaoDTO> dtos) {
		for (int i = 0 ; i < dtos.size(); i++) {
			dtos.get(i).setAvaliador(new AvaliadorDTO(avcs.get(i).getUser().getId(), avcs.get(i).getUser().getNome()));
		}
	}
}
