package caixa.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import caixa.model.Product;

public interface ProductDao extends CrudRepository<Product, Long>, JpaSpecificationExecutor<Product> {

}
