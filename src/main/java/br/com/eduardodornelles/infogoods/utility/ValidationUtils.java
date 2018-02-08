package br.com.eduardodornelles.infogoods.utility;

import org.apache.commons.validator.routines.EmailValidator;

import br.com.eduardodornelles.infogoods.domain.Messages;
import br.com.eduardodornelles.infogoods.domain.Parameters;
import br.com.eduardodornelles.infogoods.entity.User;
import br.com.eduardodornelles.infogoods.service.MessageService;

/**
 * class containing validations that are used through the application
 * 
 * @author eduardo
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
	
	
}
