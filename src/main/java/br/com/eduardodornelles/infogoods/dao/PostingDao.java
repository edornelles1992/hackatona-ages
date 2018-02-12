package br.com.eduardodornelles.infogoods.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.eduardodornelles.infogoods.entity.Posting;

public interface PostingDao  extends CrudRepository<Posting, Long>, JpaSpecificationExecutor<Posting> {

	@Override
	Collection<Posting> findAll();
}
