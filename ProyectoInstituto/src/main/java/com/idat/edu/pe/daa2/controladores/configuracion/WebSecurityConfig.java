package com.idat.edu.pe.daa2.controladores.configuracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

protected void configure (HttpSecurity http) throws Exception{
		
		http.authorizeRequests()
                    .antMatchers("/css/**", "/imagenes/**", "/js/**", "/", "/principal", "/home", 
                     "/inicio", "/logeo", "/login", "/rest/**").permitAll()
                     .antMatchers("/alumno/listarTodo").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR", "DEPURADOR")
                     .antMatchers("/alumno/nuevo").hasAnyRole("ADMIN","CREADOR")
                     .antMatchers("/alumno/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
                     .antMatchers("/alumno/actualizar/**").hasAnyRole("ADMIN","EDITOR")
                     .antMatchers("/alumno/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
                     .anyRequest().authenticated()
                     .and().formLogin().loginPage("/login").defaultSuccessUrl("/bienvenida", true).permitAll()
                     .and().logout()
                     .permitAll();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
		
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
		.withUser("anthony").password(encoder.encode("anthony")).roles("LECTOR").and()
		.withUser("diego").password(encoder.encode("diego")).roles("CREADOR").and()
		.withUser("jhosep").password(encoder.encode("jhosep")).roles("LECTOR","DEPURADOR").and()
		.withUser("jake").password(encoder.encode("jake")).roles("LECTOR","EDITOR").and();
		
	}
}
