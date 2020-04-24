package caixa.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import caixa.model.MessagesConfiguration;

@Repository
public interface MessageDao extends CrudRepository<MessagesConfiguration, String> {
}
