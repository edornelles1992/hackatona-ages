package br.com.eduardodornelles.infogoods.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import br.com.eduardodornelles.infogoods.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}
