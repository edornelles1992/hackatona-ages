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
import hackatona.model.User;
import hackatona.service.logic.UserService;

@RestController
@RequestMapping("/api/usuario")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	/**
	 * Registrar novo usuário.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> signUp(@RequestBody User user) throws Exception {
		return super.response(userService.registerUser(user), HttpStatus.OK);
	}

	/**
	 * Buscar um usuário pelo login.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findUser(@RequestParam String usuario) throws Exception {
		return super.response(userService.getUser(usuario), HttpStatus.OK);
	}

}
