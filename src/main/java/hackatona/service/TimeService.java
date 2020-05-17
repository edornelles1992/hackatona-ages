package hackatona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.TimeDao;
import hackatona.dto.HttpResponseDTO;
import hackatona.dto.TimeDTO;
import hackatona.model.Time;

@Service
public class TimeService extends AbstractService {

	@Autowired
	private TimeDao timeDao;

	public HttpResponseDTO criarTime(TimeDTO dto) {
		this.LogServiceConsumed(this.getClassName(), "criarTime");
		HttpResponseDTO response = new HttpResponseDTO();

		if (dto != null) {
			timeDao.save(modelMapper.map(dto, Time.class));
			response.setSuccess(true);
			response.addContent(dto);
			response.addMessage("time criado com sucesso");
		} else {
			response.setSuccess(false);
			response.addMessage("Erro ao criar time");
		}

		return response;
	}

	public HttpResponseDTO excluirTime(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO adicionarAluno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO removerAluno(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO listarTimes() {
		// TODO Auto-generated method stub
		return null;
	}

	public HttpResponseDTO buscarTime(Long id) {		
		return null;
	}

	public HttpResponseDTO validarTime(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
