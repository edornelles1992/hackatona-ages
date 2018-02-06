package br.com.eduardodornelles.infogoods.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.eduardodornelles.infogoods.entity.MessagesConfiguration;

@Repository
public interface MessageDao extends CrudRepository<MessagesConfiguration, String> {
}
