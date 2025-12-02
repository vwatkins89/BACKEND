package com.ecommerce.techhive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.techhive.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	boolean existsByNomeAndCategoria(String nome, String categoria);
	List<Produto> findByAtivoTrue();
}
