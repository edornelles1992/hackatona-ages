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
	private UserService userService;	
	
	/**
	 * RESTful method that register a new user.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/sign-up", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> signUp(@RequestBody User user) {		
		return super.response(userService.registerUser(user), HttpStatus.OK);
	}
	
	/**
	 * RESTful method that get an user from database.
	 * @return {@link ResponseEntity<HttpResponseDTO>}
	 * @throws Exception
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<HttpResponseDTO> findUser(String email, String password) {
		return super.response(userService.getUser(email,password), HttpStatus.OK);
	}

}
