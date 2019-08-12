package com.br.spring.relacional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Usuario;
import com.br.spring.relacional.services.LoginService;

@RestController
@RequestMapping("/api/login")
public class LoginApiRestController {

	@Autowired
	private LoginService loginService;

	@GetMapping
	public ResponseEntity<?> exibirLogin() {

		return ResponseEntity.ok(loginService.exibirTodosLogin());

	}

	@PostMapping
	public ResponseEntity<?> criarLogin(@RequestBody Login login) {

		loginService.salvarLoginApi(login);
		return ResponseEntity.status(HttpStatus.CREATED).body(login);

	}

}
