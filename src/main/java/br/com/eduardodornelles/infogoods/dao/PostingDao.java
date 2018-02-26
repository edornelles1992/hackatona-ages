package br.com.eduardodornelles.infogoods.dao;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.eduardodornelles.infogoods.domain.Querys;
import br.com.eduardodornelles.infogoods.entity.Posting;

public interface PostingDao  extends CrudRepository<Posting, Long>, JpaSpecificationExecutor<Posting> {

	@Override
	Collection<Posting> findAll();
	
	/**	  
	 * @param searchTerm
	 * @return Collection of postings with a product that contains 
	 * the searchTerm passed by parameter
	 */	
	@Query(Querys.FIND_POSTINGS_WITH_GIVEN_PRODUCT_NAME)	
	public Collection<Posting> findBySearchTermInProductName(@Param("searchTerm") String searchTerm);
}
