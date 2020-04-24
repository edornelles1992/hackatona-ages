package caixa.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import caixa.model.Cashier;

public interface CashierDao extends CrudRepository<Cashier, Long>, JpaSpecificationExecutor<Cashier> {

}