package hackatona.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Avaliacao;
import hackatona.model.User;

public interface UserDao extends CrudRepository<User, Integer>, JpaSpecificationExecutor<User>{
	
	User findByUsuario(String usuario);

    @Override
    List<User> findAll();
}
