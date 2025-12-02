package com.ecommerce.techhive.service;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.ecommerce.techhive.dto.ProdutoDto;
import com.ecommerce.techhive.exception.ResourceNotFoundException;
import com.ecommerce.techhive.model.Produto;
import com.ecommerce.techhive.repository.ProdutoRepository;

@Service
@Primary
public class ProdutoRegraService implements ProdutoService {
	private final ProdutoRepository prodRepository;

	public ProdutoRegraService(ProdutoRepository prodRepository) {
		this.prodRepository = prodRepository;
	}

	@Override
	public Produto create(ProdutoDto dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setCategoria(dto.getCategoria());
		p.setDescricao(dto.getDescricao());
		p.setMarca(dto.getMarca());
		p.setImagemUrl(dto.getImagemUrl());
		p.setPreco(dto.getPreco());
		p.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		return prodRepository.save(p);
	}

	@Override
	public Produto findById(Long id) {
		Produto p = prodRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));
		if (!p.getAtivo()) {
			throw new ResourceNotFoundException("Produto inativo!"); 
		}
		return p;
	}

	@Override
	public List<Produto> findAll() {
		return prodRepository.findAll();
	}

	@Override
	public Produto update(Long id, ProdutoDto dto) {
		Produto p = new Produto();
		p.setNome(dto.getNome());
		p.setCategoria(dto.getCategoria());
		p.setDescricao(dto.getDescricao());
		p.setMarca(dto.getMarca());
		p.setImagemUrl(dto.getImagemUrl());
		p.setPreco(dto.getPreco());
		p.setQuantidadeEstoque(dto.getQuantidadeEstoque());
		return prodRepository.save(p);
	}

	@Override
	public void delete(Long id) {
		Produto p = findById(id);
		p.setAtivo(false);
		prodRepository.save(p);
	}
	
	@Override
	public Produto activate(Long id) {
	    Produto p = prodRepository.findById(id)
	        .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado!"));
	    p.setAtivo(true);
	    return prodRepository.save(p);
	}

}
