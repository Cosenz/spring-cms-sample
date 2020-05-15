package it.cosenzproject.cmssample.app.service.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.cosenzproject.cmssample.app.entity.User;
import it.cosenzproject.cmssample.app.repository.UserRepository;
import it.cosenzproject.cmssample.app.service.UserService;
import it.cosenzproject.cmssample.common.model.AppUserDetails;
import it.cosenzproject.cmssample.common.util.Assert;

@Service(UserServiceProvider.BEAN_NAME)
public class UserServiceProvider implements UserService {

	public static final String BEAN_NAME = "it.cosenzproject.cmssample.app.service.provider.UserServiceProvider";

	@Autowired
	private UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return this.repository.findByUsername(username).map(AppUserDetails::new)
		        .orElseThrow(() -> new UsernameNotFoundException(String.format("User not found: %s", username)));
	}

	@Override
	public User loadById(Integer id) {
		return Assert.checkOptional(this.repository.findById(id), "User not found");
	}

}
