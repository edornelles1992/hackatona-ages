package br.com.eduardodornelles.infogoods.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.eduardodornelles.infogoods.entity.UserRegistry;

public interface UserDao extends CrudRepository<UserRegistry, Long>, JpaSpecificationExecutor<UserRegistry>{
	
	UserRegistry findByEmail(String email);
	
	UserRegistry findById_pessoa(Long id_pessoa);
}
