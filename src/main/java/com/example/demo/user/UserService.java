package com.example.demo.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwdEncoder;

	public SiteUser create(String userName, String email, String passwd) {
		SiteUser user = new SiteUser();
		user.setUserName(userName);
		user.setEmail(email);
//		BCryptPasswordEncoder passwdEncoder = new BCryptPasswordEncoder();
//		user.setPasswd(passwdEncoder.encode(passwd));
		user.setPasswd(passwdEncoder.encode(passwd));;
		this.userRepository.save(user);
		return user;
	}
}
