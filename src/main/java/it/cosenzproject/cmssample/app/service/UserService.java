package it.cosenzproject.cmssample.app.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import it.cosenzproject.cmssample.app.entity.User;

public interface UserService extends UserDetailsService {

	@Query("SELECT u.id, u.username, u.roles FROM User u WHERE u.id=:id")
	User loadById(@Param("id") Integer id);

}
