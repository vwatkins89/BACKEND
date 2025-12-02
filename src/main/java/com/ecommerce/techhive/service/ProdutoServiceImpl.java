package com.ecommerce.techhive.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ecommerce.techhive.dto.ProdutoDto;
import com.ecommerce.techhive.model.Produto;
import com.ecommerce.techhive.repository.ProdutoRepository;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository prodRepository;

    public ProdutoServiceImpl(ProdutoRepository prodRepository) {
        this.prodRepository = prodRepository;
    }

    @Override
    public Produto create(ProdutoDto dto) {

        if (prodRepository.existsByNomeAndCategoria(dto.getNome(), dto.getCategoria())) {
            throw new RuntimeException("Produto já cadastrado nessa categoria.");
        }

        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        produto.setMarca(dto.getMarca());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setImagemUrl(dto.getImagemUrl());
        produto.setAtivo(true);

        return prodRepository.save(produto);
    }

    @Override
    public Produto findById(Long id) {
        return prodRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado."));
    }

    @Override
    public List<Produto> findAll() {
        return prodRepository.findAll();
    }

    @Override
    public Produto update(Long id, ProdutoDto dto) {
        Produto produto = findById(id);

        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());
        produto.setPreco(dto.getPreco());
        produto.setCategoria(dto.getCategoria());
        produto.setMarca(dto.getMarca());
        produto.setQuantidadeEstoque(dto.getQuantidadeEstoque());
        produto.setImagemUrl(dto.getImagemUrl());

        return prodRepository.save(produto);
    }

    @Override
    public void delete(Long id) {
        Produto produto = findById(id);
        produto.setAtivo(false); // Soft delete
        prodRepository.save(produto);
    }

    @Override
    public Produto activate(Long id) {
        Produto produto = findById(id);
        produto.setAtivo(true);
        return prodRepository.save(produto);
    }
}