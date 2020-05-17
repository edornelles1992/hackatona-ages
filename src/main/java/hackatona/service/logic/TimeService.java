package hackatona.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AlunoDao;
import hackatona.dao.TimeDao;
import hackatona.dto.HttpResponseDTO;
import hackatona.dto.TimeDTO;
import hackatona.model.Aluno;
import hackatona.model.Time;

@Service
public class TimeService extends AbstractService {

	@Autowired
	private TimeDao timeDao;

	@Autowired
	private AlunoDao alunoDao;

	public HttpResponseDTO criarTime(TimeDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "criarTime");

		if (dto != null) {
			if (this.timeDao.findByNome(dto.getNome()) != null)
				return HttpResponseDTO.fail("Time já cadastrado.");
			return HttpResponseDTO.success(this.timeDao.save(mapper.map(dto, Time.class)));
		} else {
			return HttpResponseDTO.fail("Erro ao criar time");
		}
	}

	public HttpResponseDTO excluirTime(Long id) {
		this.LogServiceConsumed(this.getClassName(), "excluirTime");
		try {
			this.timeDao.delete(id);
			return HttpResponseDTO.success("Time apagado com sucesso!");
		} catch (Exception e) {
			return HttpResponseDTO.fail(e.getMessage());
		}
	}

	public HttpResponseDTO adicionarAluno(Long idAluno, Long idTime) {
		this.LogServiceConsumed(this.getClassName(), "adicionarAluno");
			Aluno aluno = this.alunoDao.findOne(idAluno);
			Time time = this.timeDao.findOne(idTime);
			if (aluno != null && time != null) {
				aluno.setTime(time);
				this.alunoDao.save(aluno);
				return HttpResponseDTO.success("Aluno adicionado ao time " + time.getNome() + "com sucesso!");
			} else {
				return HttpResponseDTO.fail("Erro ao adicionar o aluno ao time.");
			}
	}

	public HttpResponseDTO removerAluno(Long id) {
		this.LogServiceConsumed(this.getClassName(), "removerAluno");
		try {
			this.alunoDao.delete(id);
			return HttpResponseDTO.success("Aluno removido do time com sucesso!");
		} catch (Exception e) {
			return HttpResponseDTO.fail(e.getMessage());
		}
	}

	public HttpResponseDTO listarTimes() {
		this.LogServiceConsumed(this.getClassName(), "listarTimes");
		return HttpResponseDTO.success(mapper.map(this.timeDao.findAll(), List.class));
	}

	public HttpResponseDTO buscarTime(Long id) {
		this.LogServiceConsumed(this.getClassName(), "buscarTime");
		return HttpResponseDTO.success(mapper.map(this.timeDao.findOne(id), TimeDTO.class));
	}

	/**
	 * Valida o time com a regra de existir pelo menos uma pessoa
	 * de um curso diferente dentro do time.
	 * @param id
	 * @return HttpResponseDTO
	 */
	public HttpResponseDTO validarTime(Long id) {
		this.LogServiceConsumed(this.getClassName(), "validarTime");
		Time time = this.timeDao.findOne(id);
		if (time == null) 
			HttpResponseDTO.fail("Time não encontrado!");
		
		List<Aluno> alunos = this.alunoDao.findByTime(id);

		if (alunos == null || alunos.isEmpty())
			HttpResponseDTO.fail("Este time não possui nenhum integrante.");
		
		Aluno atual = alunos.get(0);
		for (Aluno aluno : alunos) {
			if (!atual.getId_curso().equals(aluno.getId_curso()))
				HttpResponseDTO.success("Time válido!");
		}
		
		return HttpResponseDTO.fail("Time inválido!");
	}

}
