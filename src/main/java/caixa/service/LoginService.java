package caixa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import caixa.dao.UserDao;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserDao userDao;   

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	caixa.model.User userRegistry = userDao.findByEmail(username);
        if (userRegistry == null) {
            throw new UsernameNotFoundException(username);
        }
   //     UserDetails userDetails =  new User(userRegistry.getEmail(),userRegistry.getSenha(),enabled,accountNonExpired, credentialsNonExpired,accountNonLocked,getAuthorities(user.getRole())); 
      //  UserDetails user = new User(userRegistry.getNome(), userRegistry.getSenha(), emptyList());
        
        return userRegistry;
    }	
}
