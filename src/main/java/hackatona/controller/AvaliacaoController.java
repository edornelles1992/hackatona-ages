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
import hackatona.service.logic.AvaliacaoService;

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
	public ResponseEntity<HttpResponseDTO> criarAvaliacao(@RequestParam Integer idTime, @RequestParam Integer idUsuario) throws Exception {
		return super.response(avaliacaoService.criarAvaliacao(idTime, idUsuario), HttpStatus.OK);
	}
	
	/**
	 * Criar avaliação para todos os times aptos a serem avalaidos. 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/abrirAvaliacoes", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> criarTodasAvaliacoes(@RequestParam Integer idUsuario) throws Exception {
		return super.response(avaliacaoService.criarTodasAvaliacoes(idUsuario), HttpStatus.OK);
	}
	
	/**
	 * Efetuar uma avaliação.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> efetuarAvaliacao(@RequestParam Integer idUsuario, @RequestBody AvaliacaoDTO dto) throws Exception {
		return super.response(avaliacaoService.efetuarAvaliacao(idUsuario, dto), HttpStatus.OK);
	}
	
	/**
	 * buscar avaliação.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> buscarAvaliacao(@RequestParam Integer id) throws Exception {
		return super.response(avaliacaoService.buscarAvaliacao(id), HttpStatus.OK);
	}
	
	/**
	 * listar todas avaliações.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listarAvaliacoes() throws Exception {
		return super.response(avaliacaoService.listarAvaliacoes(), HttpStatus.OK);
	}
	
	/**
	 * listar todas avaliações de um avaliador.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/list/avaliador", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> listarAvaliacoesPorAvaliador(@RequestParam Integer id) throws Exception {
		return super.response(avaliacaoService.listarAvaliacoesPorAvaliador(id), HttpStatus.OK);
	}
	
	/**
	 * excluir avaliação
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/excluir", method = RequestMethod.DELETE)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> excluirAvaliacao(@RequestParam Integer id) throws Exception {
		return super.response(avaliacaoService.excluirAvaliacao(id), HttpStatus.OK);
	}

}
