package com.br.spring.relacional.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.repositories.LoginRepository;

@Service
public class LoginService {
	
	@Autowired
	private LoginRepository loginRepository;

	public String cadastrarLogin(Usuario user, Login login) {
		login.setUsuario(user);
		loginRepository.save(login);
		return "Login cadastrado";
		
	}
	
	public void upadate(Login login) {
		loginRepository.save(login);
	}
	
	public Login buscarPorApelidoESenha(Login login) {
		return loginRepository.findByApelidoAndSenha(login.getApelido(), login.getSenha()).get();
	}
	public Iterable<Login> exibirTodosLogin(){
		return loginRepository.findAll();
	}
	
	public void salvarLoginApi(Login login) {
		loginRepository.save(login);
		
	}
}
