package hackatona.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Avaliacao;

public interface AvaliacaoDao extends CrudRepository<Avaliacao, Long>, JpaSpecificationExecutor<Avaliacao> {

}