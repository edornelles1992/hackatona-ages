package br.com.eduardodornelles.infogoods.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.eduardodornelles.infogoods.dao.UserDao;

@Service
public class LoginService implements UserDetailsService {

	@Autowired
	private UserDao userDao;   

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	br.com.eduardodornelles.infogoods.entity.User userRegistry = userDao.findByEmail(username);
        if (userRegistry == null) {
            throw new UsernameNotFoundException(username);
        }
   //     UserDetails userDetails =  new User(userRegistry.getEmail(),userRegistry.getSenha(),enabled,accountNonExpired, credentialsNonExpired,accountNonLocked,getAuthorities(user.getRole())); 
      //  UserDetails user = new User(userRegistry.getNome(), userRegistry.getSenha(), emptyList());
        
        return userRegistry;
    }	
}
