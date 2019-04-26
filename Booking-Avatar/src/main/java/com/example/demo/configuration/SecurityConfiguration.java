package com.example.demo.configuration;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.repository.AvatarRepository;
import com.example.demo.repository.PersoneRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.repository.adminRepository;
import com.example.demo.service.MyUserDetailsService;



@Configuration
@EnableWebSecurity

public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	

	@Autowired
	adminRepository adminrepository;
	@Autowired
	AvatarRepository avatarRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	PersoneRepository personeRepository;
	
	
@Value("${spring.queries.users-query}")
	private String usersQuery;
	
	@Value("${spring.queries.roles-query}")
	private String rolesQuery;
	

	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	List<com.example.demo.model.Admin> admins =adminrepository.findAll();
	 for (com.example.demo.model.Admin admin : admins) {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(admin.getEmail())
                    .password(admin.getPassword())
                    	.roles("Admin");
            
    }
	 
	 List<com.example.demo.model.Avatar> avatars =avatarRepository.findAll();
	 for (com.example.demo.model.Avatar avatar : avatars) {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(avatar.getEmail())
                    .password(avatar.getPassword())
                    	.roles("Avatar");
            
    }
	 
	 List<com.example.demo.model.User> users =userRepository.findAll();
	 for (com.example.demo.model.User user : users) {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser(user.getEmail())
                    .password(user.getPassword())
                    	.roles("User");
            
    }
	 

	}
	

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf()
				.disable()
					.authorizeRequests()
						.antMatchers("/login")
							.permitAll()
							.antMatchers("/admin/HomeAdmin/**")
							.hasRole("Admin")
							
							.antMatchers("/avatar/avatarHome/**")
							.hasRole("Avatar")
							
							
							.antMatchers("/user/userHome/**")
							.hasRole("User")
							
								.and()
			.authorizeRequests()
				.antMatchers("/css/**","/fonts/**","image/**","/js/**","/table/**","/img/**","/registration/**","/HomeApp")//autrisé l'acces lel les url hethom sans passe pas l'etape de login 
					.permitAll()
						.anyRequest()
							.authenticated()
								.and()
			.formLogin()
				.loginPage("/login")
					.permitAll()
						.defaultSuccessUrl("/default", true)
				 			.and()
			.logout()
				.invalidateHttpSession(true)
						.clearAuthentication(true)
							.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
								.logoutSuccessUrl("/login")
									.permitAll();

	
	}
	

}//crud =c= insertion / r=afiche / update / delete 
