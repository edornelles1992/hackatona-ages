package hackatona.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AlunoDao;
import hackatona.domain.Cursos;
import hackatona.dto.AlunoDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.model.Aluno;
import hackatona.service.consumer.AlunoServiceConsumer;
import hackatona.utility.ValidationUtils;

/**
 * 
 * 
 * @author Eduardo Dornelles
 */
@Service
public class AlunoService extends AbstractService {

	@Autowired
	private AlunoDao alunoDao;
	
	@Autowired
	private AlunoServiceConsumer alunoServiceConsumer;

	public HttpResponseDTO listAlunos() {
		this.LogServiceConsumed(this.getClassName(), "listAlunos");
		HttpResponseDTO response = new HttpResponseDTO();

		List<AlunoDTO> list = mapper.mapAll(alunoDao.findAll(), AlunoDTO.class);
		response.setSuccess(true);
		response.addContent("list", list);
		return response;
	}

	public HttpResponseDTO getAluno(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "getAluno");
		HttpResponseDTO response = new HttpResponseDTO();

		AlunoDTO productDto = mapper.map(alunoDao.findById(id).get(), AlunoDTO.class);
		if (productDto != null) {
			response.setSuccess(true);
			response.addContent(productDto);
		} else {
			response.setSuccess(false);
			response.addMessage("Aluno não encontrado!");
		}
		return response;
	}

	public HttpResponseDTO cadastrarAluno(AlunoDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "cadastrarAluno");
		
		String erro = ValidationUtils.validarCadastroAluno(dto);
		
		if (erro != null) 
			return HttpResponseDTO.fail(erro);				
		if (alunoDao.findByMatricula(dto.getMatricula()) != null) 
			return HttpResponseDTO.fail("Aluno já cadastrado.");

		alunoDao.save(mapper.map(dto, Aluno.class));
		return HttpResponseDTO.success("Aluno cadastrado com sucesso!");
	}

	public HttpResponseDTO importarAlunos() {
		this.LogServiceConsumed(this.getClassName(), "importarAlunos");
		List<AlunoDTO> alunos = this.alunoServiceConsumer.importarAlunos();
		return HttpResponseDTO.success(alunos);
	}
	
	public HttpResponseDTO listarCursos() {
		this.LogServiceConsumed(this.getClassName(), "listarCursos");
		return HttpResponseDTO.success(Cursos.list());
	}
}
