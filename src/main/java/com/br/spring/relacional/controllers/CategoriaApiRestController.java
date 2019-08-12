package com.br.spring.relacional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.br.spring.relacional.models.Categoria;
import com.br.spring.relacional.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaApiRestController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public ResponseEntity<?> exibirCategorias() {

		return ResponseEntity.ok(categoriaService.buscarTodasCategorias());

	}

	@PostMapping
	public ResponseEntity<?> criarLogin(@RequestBody Categoria categoria) {

		categoriaService.cadastrarCategoria(categoria);
		return ResponseEntity.status(HttpStatus.CREATED).body(categoria);

	}

}
