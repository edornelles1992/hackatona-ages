package br.com.eduardodornelles.infogoods.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.dto.UserDTO;
import br.com.eduardodornelles.infogoods.entity.User;

/**
 * class that have method related to services concerning users
 * 
 * @author Eduardo Dornelles
 */
@Service
public class UserService extends AbstractService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	/**
	 * retrieve a user from database based on its email and password.
	 * 
	 * @param email
	 * @param password
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO getUser(String email, String password) {
		HttpResponseDTO response = new HttpResponseDTO();

		User user = userDao.findByEmailAndSenha(email, password);

		if (user != null) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			response.setSuccess(true);
			response.addContent("user", userDTO);
			return response;
		} else {
			response.addMessage(this.messageService.getMessageDTOByCode("A001"));
			response.setSuccess(false);
			return response;
		}
	}

	/**
	 * register an user on database. *
	 * 
	 * @param user
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO registerUser(User user) {
			HttpResponseDTO response = new HttpResponseDTO();
		if (user != null) {			
			user.setSenha(bCryptPasswordEncoder.encode(user.getSenha()));
			userDao.save(user);
			response.setSuccess(true);
			response.addMessage(this.messageService.getMessageDTOByCode("A002"));
			return response;
		} else {
			response.setSuccess(false);
			response.addMessage(this.messageService.getMessageDTOByCode("A003"));
			return response;
		}
	}

}
