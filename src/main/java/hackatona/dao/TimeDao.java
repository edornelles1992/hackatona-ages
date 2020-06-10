package hackatona.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Time;

public interface TimeDao extends CrudRepository<Time, Integer>, JpaSpecificationExecutor<Time> {

	Time findByNome(String nome);
	
    @Override
    List<Time> findAll();
}