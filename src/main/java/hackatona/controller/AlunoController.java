package hackatona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hackatona.dto.AlunoDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.service.logic.AlunoService;

@RestController
@RequestMapping("/api/aluno")
public class AlunoController extends AbstractController {

	@Autowired
	private AlunoService alunoService;
	
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listAlunos() throws Exception {
		return super.response(alunoService.listAlunos(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> getAluno(Long id) throws Exception {
		return super.response(alunoService.getAluno(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> cadastrarAluno(@RequestBody AlunoDTO dto) throws Exception {
		return super.response(alunoService.cadastrarAluno(dto), HttpStatus.OK);
	}	

	@RequestMapping(value = "/importar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> importarAlunos() throws Exception {
		return super.response(alunoService.importarAlunos(), HttpStatus.OK);
	}	
}
