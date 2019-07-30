package com.br.spring.relacional.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.spring.relacional.models.Login;
import com.br.spring.relacional.models.Produto;
import com.br.spring.relacional.services.ProdutoService;

@RestController
@RequestMapping("/api/produto")
public class ProdutoApiRestController {

	@Autowired
	private ProdutoService produtoService;

	@GetMapping
	public ResponseEntity<?> exibirProdutos() {

		return ResponseEntity.ok(produtoService.buscarTodosPrdutos());

	}

	@PostMapping
	public ResponseEntity<?> alvarProduto(@RequestBody Produto produto) {

		produtoService.salvarProduto(produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produto);

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProdutoPorId(@PathVariable int id) {
		return ResponseEntity.ok(produtoService.buscarProduto(id));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
		produtoService.atualizarProduto(id, produto);
		return ResponseEntity.ok(produto);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletarProduto(@PathVariable int id) {
		produtoService.deleteProduto(id);
		return ResponseEntity.ok().build();

	}

}
