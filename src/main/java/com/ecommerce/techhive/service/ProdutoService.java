package com.ecommerce.techhive.service;

import java.util.List;

import com.ecommerce.techhive.dto.ProdutoDto;
import com.ecommerce.techhive.model.Produto;

public interface ProdutoService {
	Produto create(ProdutoDto dto);

	Produto findById(Long id);

	List<Produto> findAll();

	Produto update(Long id, ProdutoDto dto);

	void delete(Long id);
	
	Produto activate(Long id);

}
