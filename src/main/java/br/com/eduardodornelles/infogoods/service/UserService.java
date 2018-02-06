package br.com.eduardodornelles.infogoods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.dao.UserDao;
import br.com.eduardodornelles.infogoods.dto.HttpResponseDTO;
import br.com.eduardodornelles.infogoods.entity.User;

@Service
public class UserService {

	@Autowired
	UserDao userDao;
	
	public HttpResponseDTO getUser(String email, String password) {
		HttpResponseDTO response = new HttpResponseDTO();
		
		User user = userDao.findByEmailAndSenha(email, password);
		
		response.addContent("user",user);
		
		return response;
	}

}
