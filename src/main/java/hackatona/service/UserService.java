package hackatona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hackatona.dao.UserDao;
import hackatona.domain.Messages;
import hackatona.domain.Parameters;
import hackatona.dto.HttpResponseDTO;
import hackatona.dto.UserDTO;
import hackatona.model.User;
import hackatona.utility.ValidationUtils;

/**
 * class that have method related to services concerning users
 * 
 * @author Eduardo Dornelles
 */
@Service
public class UserService extends AbstractService {

	@Autowired
	protected UserDao userDao;

	/**
	 * retrieve a user from database based on its email and password.
	 * 
	 * @param email
	 * @param password
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO getUser(final String usuario) {
		this.LogServiceConsumed(this.getClassName(), "getUser");
		HttpResponseDTO response = new HttpResponseDTO();

		User user = userDao.findByUsuario(usuario);

		if (user != null) {
			UserDTO userDTO = modelMapper.map(user, UserDTO.class);
			response.setSuccess(true);
			response.addContent("user", userDTO);
			return response;
		} else {
			response.addMessage(Messages.A001);
			response.setSuccess(false);
			return response;
		}
	}

	/**
	 * register an user on database.
	 * 
	 * @param user
	 * @return HttpResponseDTO response
	 */
	public HttpResponseDTO registerUser(final User user) {
		this.LogServiceConsumed(this.getClassName(), "registerUser");
		HttpResponseDTO response = new HttpResponseDTO();
		String errorMessage = ValidationUtils.validateUserFields(user);

		if (errorMessage.equals(Parameters.AUTHORIZED)) {
			userDao.save(user);
			response.setSuccess(true);
			response.addMessage(Messages.A002);
		} else {
			response.setSuccess(false);
			response.addMessage(errorMessage);
		}
		return response;
	}

}
