package hackatona.service.logic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AlunoDao;
import hackatona.dao.AvaliacaoDao;
import hackatona.dao.TimeDao;
import hackatona.dto.HttpResponseDTO;
import hackatona.dto.NotasDTO;
import hackatona.dto.TimeDTO;
import hackatona.model.Aluno;
import hackatona.model.Avaliacao;
import hackatona.model.Time;
import javassist.bytecode.stackmap.TypeData.ClassName;

@Service
public class TimeService extends AbstractService {

	@Autowired
	private TimeDao timeDao;

	@Autowired
	private AlunoDao alunoDao;

	@Autowired
	private AvaliacaoDao avaliacaoDao;

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

	public HttpResponseDTO excluirTime(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "excluirTime");
		try {
			Time time = this.timeDao.findById(id).get();
			List<Aluno> alunos = this.alunoDao.findByTime(time);
			for (Aluno aluno : alunos) {
				aluno.setTime(null);
				this.alunoDao.save(aluno);
			}
			this.timeDao.deleteById(id);
			return HttpResponseDTO.success("Time apagado com sucesso!");
		} catch (Exception e) {
			return HttpResponseDTO.fail(e.getMessage());
		}
	}

	public HttpResponseDTO adicionarAluno(Integer idAluno, Integer idTime) {
		this.LogServiceConsumed(this.getClassName(), "adicionarAluno");
		Aluno aluno = this.alunoDao.findById(idAluno).get();
		Time time = this.timeDao.findById(idTime).get();
		if (aluno != null && time != null) {
			aluno.setTime(time);
			this.alunoDao.save(aluno);
			return HttpResponseDTO.success("Aluno adicionado ao time " + time.getNome() + " com sucesso!");
		} else {
			return HttpResponseDTO.fail("Erro ao adicionar o aluno ao time.");
		}
	}

	public HttpResponseDTO removerAluno(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "removerAluno");
		try {
			Aluno aluno = this.alunoDao.findById(id).get();
			aluno.setTime(null);
			this.alunoDao.save(aluno);
			return HttpResponseDTO.success("Aluno removido do time com sucesso!");
		} catch (Exception e) {
			return HttpResponseDTO.fail(e.getMessage());
		}
	}

	public HttpResponseDTO listarTimes() {
		this.LogServiceConsumed(this.getClassName(), "listarTimes");
		return HttpResponseDTO.success("list", mapper.mapAll(this.timeDao.findAll(), TimeDTO.class));
	}

	public HttpResponseDTO buscarTime(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "buscarTime");
		return HttpResponseDTO.success(mapper.map(this.timeDao.findById(id).get(), TimeDTO.class));
	}

	/**
	 * Valida o time com a regra de existir pelo menos uma pessoa de um curso
	 * diferente dentro do time.
	 * 
	 * @param id
	 * @return HttpResponseDTO
	 */
	public HttpResponseDTO validarTime(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "validarTime");
		Time time = this.timeDao.findById(id).get();
		if (time == null)
			HttpResponseDTO.fail("Time não encontrado!");

		List<Aluno> alunos = this.alunoDao.findByTime(time);

		if (alunos == null || alunos.isEmpty())
			HttpResponseDTO.fail("Este time não possui nenhum integrante.");

		Aluno atual = alunos.get(0);
		for (Aluno aluno : alunos) {
			if (!atual.getId_curso().equals(aluno.getId_curso()))
				return HttpResponseDTO.success("Time válido!");
		}

		return HttpResponseDTO.fail("Time inválido!");
	}

	public HttpResponseDTO somarNotasDoTime(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "somarNotasDoTime");

		Time time = this.timeDao.findById(id).get();
		List<Avaliacao> avaliacoes = this.avaliacaoDao.findByTime(time);

		NotasDTO dto = this.somaNotas(avaliacoes);		
		dto.setTimeDTO(this.mapper.map(time, TimeDTO.class));
		return HttpResponseDTO.success("resultado", dto);
	}

	private NotasDTO somaNotas(List<Avaliacao> avaliacoes) {
		NotasDTO dto = new NotasDTO();

		for (Avaliacao ava : avaliacoes) {
			dto.setInovacao(dto.getInovacao() + (ava.getInovacao() == null ? 0 : ava.getInovacao()));
			dto.setPitch(dto.getPitch() + (ava.getPitch() == null ? 0 : ava.getPitch()));
			dto.setProcesso(dto.getProcesso() + (ava.getProcesso() == null ? 0 : ava.getProcesso()));
			dto.setSoftware(dto.getSoftware() + (ava.getSoftware() == null ? 0 : ava.getSoftware()));
			dto.setTotal(dto.getInovacao() + dto.getPitch() + dto.getProcesso() + dto.getSoftware());
			if (ava.getInovacao() != null) dto.setAvaliacoes(dto.getAvaliacoes() + 1);
		}
		return dto;
	}

	/**
	 * Soma as notas de todos os times e retorna a lista de resultados
	 * ordenadas pela maior pontuação total.
	 * @return HttpResponseDTO
	 */
	public HttpResponseDTO calcularResultados() {
		this.LogServiceConsumed(this.getClassName(), "calcularResultados");
		List<Time> times = this.timeDao.findAll();	
		List<NotasDTO> notas = new ArrayList<>();
		
		for (Time time : times) {
			List<Avaliacao> avaliacoes = this.avaliacaoDao.findByTime(time);
			NotasDTO resultado = somaNotas(avaliacoes);	
			resultado.setTimeDTO(this.mapper.map(time, TimeDTO.class));
			notas.add(resultado);
		}
		
		notas.sort(Comparator.comparing(NotasDTO::getTotal).reversed());
		
		return  HttpResponseDTO.success("resultadoFinal", notas);
	}
}
