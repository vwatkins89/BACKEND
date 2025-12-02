package com.ecommerce.techhive.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.techhive.dto.CategoriaRequestDto;
import com.ecommerce.techhive.dto.CategoriaResponseDto;
import com.ecommerce.techhive.model.Categoria;
import com.ecommerce.techhive.service.CategoriaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

	private final CategoriaService service;

	public CategoriaController(CategoriaService service) {
		this.service = service;
	}

	@Transactional
	@PostMapping
	public ResponseEntity<CategoriaResponseDto> criar(@Valid @RequestBody CategoriaRequestDto dto) {
		Categoria criada = service.criar(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(service.toResponse(criada));
	}

	@GetMapping
	public ResponseEntity<List<CategoriaResponseDto>> listarTodos() {
		return ResponseEntity.ok(service.listar());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(service.toResponse(service.buscar(id)));
	}

	@Transactional
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> atualizar(@PathVariable Long id,
			@Valid @RequestBody CategoriaRequestDto dto) {
		return ResponseEntity.ok(service.toResponse(service.atualizar(id, dto)));
	}

	@Transactional
	@PatchMapping("/{id}")
	public ResponseEntity<CategoriaResponseDto> atualizarParcial(@PathVariable Long id,
			@RequestBody CategoriaRequestDto dto) {
		return ResponseEntity.ok(service.toResponse(service.atualizarParcial(id, dto)));
	}

	@Transactional
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}