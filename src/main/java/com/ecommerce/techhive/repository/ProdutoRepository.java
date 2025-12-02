package com.ecommerce.techhive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerce.techhive.model.Produto;
import com.ecommerce.techhive.model.Categoria;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	boolean existsByNomeAndCategoria(String nome, Categoria categoria);
}
