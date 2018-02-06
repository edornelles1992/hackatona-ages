package br.com.eduardodornelles.infogoods.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.eduardodornelles.infogoods.dao.UserDao;
import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.entity.User;
import br.com.eduardodornelles.infogoods.service.UserService;

@RestController
@RequestMapping("/api/usuarios")
public class UserController extends AbstractController {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private UserService userService;
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

	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public void signUp(@RequestBody User user) {
		HttpResponseDTO resposta = new HttpResponseDTO();
		user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
		userDao.save(user);
		resposta.setSuccess(true);
		resposta.addContent("valor", "Conta criada com sucesso");
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findUser(String email, String password) {

		return super.response(userService.getUser(email,password), HttpStatus.OK);
	}

}
