package hackatona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.AlunoDao;
import hackatona.dto.HttpResponseDTO;
import hackatona.dto.AlunoDTO;

/**
 * 
 * 
 * @author Eduardo Dornelles
 */
@Service
public class AlunoService extends AbstractService {

	@Autowired
	private AlunoDao alunoDao;

	public HttpResponseDTO listAlunos() {
		this.LogServiceConsumed(this.getClassName(), "listAlunos");
		HttpResponseDTO response = new HttpResponseDTO();

		List<AlunoDTO> list = modelMapper.map(alunoDao.findAll(), List.class);
		response.setSuccess(true);
		response.addContent(list);
		return response;
	}

	public HttpResponseDTO getAluno(Long id) {
		this.LogServiceConsumed(this.getClassName(), "getAluno");
		HttpResponseDTO response = new HttpResponseDTO();

		AlunoDTO productDto = modelMapper.map(alunoDao.findOne(id), AlunoDTO.class);
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
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO importarAlunos() {
		// TODO Auto-generated method stub
		return null;
	}

}
