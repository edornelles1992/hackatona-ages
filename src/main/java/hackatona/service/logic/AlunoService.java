package hackatona.service.logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AlunoDao;
import hackatona.dao.UserDao;
import hackatona.domain.Cursos;
import hackatona.dto.AlunoDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.model.Aluno;
import hackatona.service.consumer.AlunoServiceConsumer;
import hackatona.utility.ObjectMapperUtils;
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
	private UserDao userDao;
	
	@Autowired
	private AlunoServiceConsumer alunoServiceConsumer;

	public HttpResponseDTO listAlunos() {
		this.LogServiceConsumed(this.getClassName(), "listAlunos");
		HttpResponseDTO response = new HttpResponseDTO();

		List<AlunoDTO> list = ObjectMapperUtils.getInstancia().mapAll(alunoDao.findAll(), AlunoDTO.class);
		response.setSuccess(true);
		response.addContent("list", list);
		return response;
	}

	public HttpResponseDTO getAluno(Integer id) {
		this.LogServiceConsumed(this.getClassName(), "getAluno");
		HttpResponseDTO response = new HttpResponseDTO();

		AlunoDTO productDto = ObjectMapperUtils.getInstancia().map(alunoDao.findById(id).get(), AlunoDTO.class);
		if (productDto != null) {
			response.setSuccess(true);
			response.addContent(productDto);
		} else {
			response.setSuccess(false);
			response.addMessage("Aluno não encontrado!");
		}
		return response;
	}

	public HttpResponseDTO cadastrarAluno(Integer idUsuario, AlunoDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "cadastrarAluno");
		
		if (userDao.findById(idUsuario).get().getPerfil() != 1) {
			return HttpResponseDTO.fail("Você não possui permissão para cadastrar alunos.");
		}
		
		String erro = ValidationUtils.validarCadastroAluno(dto);
		
		if (erro != null) 
			return HttpResponseDTO.fail(erro);				
		if (alunoDao.findByMatricula(dto.getMatricula()) != null) 
			return HttpResponseDTO.fail("Aluno já cadastrado.");
		
		return HttpResponseDTO.success(alunoDao.save(ObjectMapperUtils.getInstancia().map(dto, Aluno.class)));
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
