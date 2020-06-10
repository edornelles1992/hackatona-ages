package hackatona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import hackatona.dto.HttpResponseDTO;
import hackatona.dto.TimeDTO;
import hackatona.service.logic.TimeService;

@RestController
@RequestMapping("/api/time")
public class TimeController extends AbstractController {

	@Autowired
	private TimeService timeService;
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listarTimes() throws Exception {
		return super.response(timeService.listarTimes(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> getTime(@RequestParam Integer id) throws Exception {
		return super.response(timeService.buscarTime(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/criar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> criarTime(@RequestBody TimeDTO dto) throws Exception {
		return super.response(timeService.criarTime(dto), HttpStatus.OK);
	}

	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> excluirTime(@RequestParam Integer id) throws Exception {
		return super.response(timeService.excluirTime(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/adicionar_aluno", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> adicionarIntegrante(@RequestParam Integer idAluno, @RequestParam Integer idTime) throws Exception {
		return super.response(timeService.adicionarAluno(idTime, idTime), HttpStatus.OK);
	}

	@RequestMapping(value = "/remover_aluno", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> removerAluno(@RequestParam Integer id) throws Exception {
		return super.response(timeService.removerAluno(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/validar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> validarTime(@RequestParam Integer id) throws Exception {
		return super.response(timeService.validarTime(id), HttpStatus.OK);
	}
}
