package hackatona.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Avaliacao;
import hackatona.model.Time;
import hackatona.model.User;

public interface AvaliacaoDao extends CrudRepository<Avaliacao, Long>, JpaSpecificationExecutor<Avaliacao> {

	Avaliacao findByUserAndTime(User usuario, Time time);
	
	List<Avaliacao> findByUser(User usuario);
	
    @Override
    List<Avaliacao> findAll();
}