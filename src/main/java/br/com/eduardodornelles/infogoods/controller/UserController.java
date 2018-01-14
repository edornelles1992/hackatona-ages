package br.com.eduardodornelles.infogoods.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends AbstractController {

	/**
	 * RESTful method that get all prizes availables that can be redemeed by the
	 * user *
	 *
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> Test() throws Exception {
		HttpResponseDTO resposta = new HttpResponseDTO();
		resposta.setSuccess(true);
		resposta.addContent("valor", "teste");
		return super.response(resposta, HttpStatus.OK);
	}

	@RequestMapping("/users")
	@ResponseBody
	public String getUsers() {
		return "{\"users\":[{\"name\":\"Lucas\", \"country\":\"Brazil\"},"
				+ "{\"name\":\"Jackie\",\"country\":\"China\"}]}";

	}
	
}
