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

import hackatona.dto.AvaliacaoDTO;
import hackatona.dto.HttpResponseDTO;
import hackatona.service.AvaliacaoService;

@RestController
@RequestMapping("/api/avaliacao")
public class AvaliacaoController extends AbstractController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	
	/**
	 * Criar avaliação de um time para um usuário realizar. 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/abrir", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> criarAvaliacao(@RequestParam Long idTime, @RequestParam Long idUsuario) throws Exception {
		return super.response(avaliacaoService.criarAvaliacao(idTime, idUsuario), HttpStatus.OK);
	}
	
	/**
	 * Efetuar uma avaliação.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> efetuarAvaliacao(@RequestBody AvaliacaoDTO dto) throws Exception {
		return super.response(avaliacaoService.efetuarAvaliacao(dto), HttpStatus.OK);
	}
	
	/**
	 * buscar avaliação.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> buscarAvaliacao(Long id) {
		return super.response(avaliacaoService.buscarAvaliacao(id), HttpStatus.OK);
	}
	
	/**
	 * listar todas avaliações.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listarAvaliacoes(Long id) throws Exception {
		return super.response(avaliacaoService.listarAvaliacoes(id), HttpStatus.OK);
	}

}
