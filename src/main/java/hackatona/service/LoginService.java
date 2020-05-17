package hackatona.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import hackatona.dao.UserDao;
import hackatona.model.User;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserDao userDao;   

    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
    	User userRegistry = userDao.findByUsuario(usuario);
        if (userRegistry == null) {
            throw new UsernameNotFoundException(usuario);
        }
        return userRegistry;
    }	
}
