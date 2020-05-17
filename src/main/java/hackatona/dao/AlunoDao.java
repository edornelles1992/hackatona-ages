package hackatona.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Aluno;

public interface AlunoDao extends CrudRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {

	Aluno findByMatricula(String matricula);
	
	List<Aluno> findByTime(Long idTime);
}
