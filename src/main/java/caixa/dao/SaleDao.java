package caixa.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import caixa.model.Sale;

public interface SaleDao extends CrudRepository<Sale, Long>, JpaSpecificationExecutor<Sale> {

}