package br.com.eduardodornelles.infogoods.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eduardodornelles.infogoods.dao.UserDao;

public class AbstractService {

	/**
	 * User repository that allow to search on table T_PESSOA.
	 */
	@Autowired
	protected UserDao userDao;
	
	/**
	 * Messages repository that allow to search on table T_MENSAGEM
	 */
	@Autowired
	protected MessageService messageService;
	
	/**
	 * ModelMapper Instance to convert DTO to Entity and vice-versa
	 */
	@Autowired
	protected ModelMapper modelMapper;
}
