package br.com.eduardodornelles.infogoods.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.eduardodornelles.infogoods.entity.User;

public interface UserDao extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	User findByEmail(String email);
	
	User findByEmailAndSenha(String email, String password);
	
}
