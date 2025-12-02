package com.ecommerce.techhive.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.techhive.dto.ProdutoDto;
import com.ecommerce.techhive.model.Produto;
import com.ecommerce.techhive.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	 private final ProdutoService prodService;

	    public ProdutoController(ProdutoService prodService) {
	        this.prodService = prodService;
	    }

	    @PostMapping
	    public Produto create(@RequestBody ProdutoDto prodDto) {
	        return prodService.create(prodDto);
	    }

	    @GetMapping
	    public List<Produto> listAll() {
	        return prodService.findAll();
	    }

	    @GetMapping("/{id}")
	    public Produto findOne(@PathVariable Long id) {
	        return prodService.findById(id);
	    }

	    @PutMapping("/{id}")
	    public Produto update(@PathVariable Long id, @RequestBody ProdutoDto prodDto) {
	        return prodService.update(id, prodDto);
	    }

	    @DeleteMapping("/{id}")
	    public void delete(@PathVariable Long id) {
	    	prodService.delete(id);
	    }
	    
	    @PutMapping("/{id}/isactivate")
	    public ResponseEntity<Produto> activate(@PathVariable Long id) {
	        Produto produtoAtivo = prodService.activate(id);
	        return ResponseEntity.ok(produtoAtivo);
	    }

}
