package caixa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import caixa.dto.HttpResponseDTO;
import caixa.model.User;
import caixa.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends AbstractController {

	@Autowired
	private UserService userService;

	/**
	 * Registrar novo usuário.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> signUp(@RequestBody User user) throws Exception {
		return super.response(userService.registerUser(user), HttpStatus.OK);
	}

	/**
	 * Buscar um usuário.
	 * 
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/usuario", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findUser(@RequestParam(value = "email") String email,
			@RequestParam(value = "senha") String senha) throws Exception {
		return super.response(userService.getUser(email, senha), HttpStatus.OK);
	}

}
