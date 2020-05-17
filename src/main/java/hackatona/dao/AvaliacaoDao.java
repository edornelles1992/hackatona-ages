package hackatona.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import hackatona.model.Avaliacao;
import hackatona.model.Time;
import hackatona.model.User;

public interface AvaliacaoDao extends CrudRepository<Avaliacao, Long>, JpaSpecificationExecutor<Avaliacao> {

	Avaliacao findByUsuarioAndTime(User usuario, Time time);
}