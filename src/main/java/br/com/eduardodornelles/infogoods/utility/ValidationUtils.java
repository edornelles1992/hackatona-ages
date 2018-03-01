package br.com.eduardodornelles.infogoods.utility;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.eduardodornelles.infogoods.domain.Messages;
import br.com.eduardodornelles.infogoods.domain.Parameters;
import br.com.eduardodornelles.infogoods.dto.PostingDTO;
import br.com.eduardodornelles.infogoods.entity.User;
import br.com.eduardodornelles.infogoods.service.MessageService;

/**
 * class containing validations that are used through the application
 *  
 * @author Eduardo Dornelles
 *
 */
public class ValidationUtils {	

	static MessageService messageService = new MessageService();

	/**
	 * method to validate all fields and the object received when an user sign-up.
	 * 
	 * @param user
	 * @return
	 */
	public static String validateUserFields(User user) {

		if (user == null)
			return Messages.A003;
		if (user.getEmail() == null || user.getSenha() == null || user.getEstado() == null || user.getCidade() == null
				|| user.getNome() == null || user.getDataNascimento() == null)
			return Messages.A004;
		if (user.getEmail() == "" || user.getSenha() == "" || user.getEstado() == "" || user.getCidade() == ""
				|| user.getNome() == "")
			return Messages.A004;
		if (!EmailValidator.getInstance().isValid(user.getEmail()))
			return Messages.A005;
		if (user.getSenha().length() < Parameters.PASSWORD_MIN_SIZE)
			return Messages.A006;
		
		return Parameters.AUTHORIZED;
	}
	
	/**
	 * validating if any field inside the object is null
	 * throw a NullPointerException if exists.
	 * @param postingDTO
	 * @return boolean
	 * @throws NullPointerException
	 */
	public static boolean validateEmptyPostFields(PostingDTO postingDTO) throws NullPointerException{
		
		if (postingDTO == null) throw new NullPointerException();
		if (postingDTO.getCurtidas() == null) throw new NullPointerException();
		if (postingDTO.getDataPublicacao() == null) throw new NullPointerException();
		if (postingDTO.getId() == null) throw new NullPointerException();
		if (postingDTO.getProduto() == null) throw new NullPointerException();
		if (postingDTO.getUser() == null) throw new NullPointerException();
		
		if (postingDTO.getProduto().getFabricante() == null) throw new NullPointerException();
		if (postingDTO.getProduto().getFoto() == null) throw new NullPointerException();
		if (postingDTO.getProduto().getId() == null) throw new NullPointerException();
		if (postingDTO.getProduto().getModelo() == null) throw new NullPointerException();
		if (postingDTO.getProduto().getNome() == null) throw new NullPointerException();
		if (postingDTO.getProduto().getNota() == null) throw new NullPointerException();
		
		if (postingDTO.getUser().getCidade()== null) throw new NullPointerException();
		if (postingDTO.getUser().getDataNascimento()== null) throw new NullPointerException();
		if (postingDTO.getUser().getEmail()== null) throw new NullPointerException();
		if (postingDTO.getUser().getEstado()== null) throw new NullPointerException();
		if (postingDTO.getUser().getId()== null) throw new NullPointerException();
		if (postingDTO.getUser().getNome()== null) throw new NullPointerException();		
		
		return true;
	}
	
}
