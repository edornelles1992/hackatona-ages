package caixa.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import caixa.model.User;

public interface UserDao extends CrudRepository<User, Long>, JpaSpecificationExecutor<User>{
	
	User findByEmail(String email);
	
	User findByEmailAndSenha(String email, String password);
	
}
