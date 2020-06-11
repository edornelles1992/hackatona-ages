package hackatona.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Aluno;
import hackatona.model.Time;

public interface AlunoDao extends CrudRepository<Aluno, Integer>, JpaSpecificationExecutor<Aluno> {

	Aluno findByMatricula(String matricula);
	
	List<Aluno> findByTime(Time time);
	
    @Override
    List<Aluno> findAll();
}
