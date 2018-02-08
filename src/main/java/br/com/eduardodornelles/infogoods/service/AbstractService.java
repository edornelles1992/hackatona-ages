package br.com.eduardodornelles.infogoods.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eduardodornelles.infogoods.dao.CommentDao;
import br.com.eduardodornelles.infogoods.dao.PostingDao;
import br.com.eduardodornelles.infogoods.dao.ProductDao;
import br.com.eduardodornelles.infogoods.dao.UserDao;
/**
 * Abstract class containing the Daos and 
 * other things useful to all services classes. 
 * @author Eduardo Dornelles
 *
 */
public class AbstractService {

	/**
	 * User repository that allow to search on table T_PESSOA.
	 */
	@Autowired
	protected UserDao userDao;
	
	/**
	 * User repository that allow to search on table T_PRODUTO.
	 */
	@Autowired
	protected ProductDao ProductDao;
	
	/**
	 * User repository that allow to search on table T_POSTAGEM.
	 */
	@Autowired
	protected PostingDao postingDao;
	
	/**
	 * User repository that allow to search on table T_COMENTARIO.
	 */
	@Autowired
	protected CommentDao CommentDao;
	
	/**
	 * Messages repository that allow to search on table T_MENSAGEM
	 */
	@Autowired
	protected MessageService messageService;
	
	/**
	 * ModelMapper Instance to convert DTO to Entity and vice versa
	 */
	@Autowired
	protected ModelMapper modelMapper;
}
