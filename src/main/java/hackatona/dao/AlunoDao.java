package hackatona.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Aluno;

public interface AlunoDao extends CrudRepository<Aluno, Long>, JpaSpecificationExecutor<Aluno> {

}
