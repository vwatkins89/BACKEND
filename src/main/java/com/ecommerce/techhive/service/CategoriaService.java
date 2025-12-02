package com.ecommerce.techhive.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.techhive.dto.CategoriaRequestDto;
import com.ecommerce.techhive.dto.CategoriaResponseDto;
import com.ecommerce.techhive.model.Categoria;
import com.ecommerce.techhive.exception.ResourceNotFoundException;
import com.ecommerce.techhive.repository.CategoriaRepository;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Categoria criar(CategoriaRequestDto dto) {
        Categoria c = new Categoria();
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        return repo.save(c);
    }

    @Transactional(readOnly = true)
    public List<CategoriaResponseDto> listar() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    @Transactional(readOnly = true)
    public Categoria buscar(Long id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada: " + id));
    }

    @Transactional
    public Categoria atualizar(Long id, CategoriaRequestDto dto) {
        Categoria c = buscar(id);
        c.setNome(dto.getNome());
        c.setDescricao(dto.getDescricao());
        return repo.save(c);
    }

    @Transactional
    public Categoria atualizarParcial(Long id, CategoriaRequestDto dto) {
        Categoria c = buscar(id);
        if (dto.getNome() != null && !dto.getNome().isBlank()) c.setNome(dto.getNome());
        if (dto.getDescricao() != null) c.setDescricao(dto.getDescricao());
        return repo.save(c);
    }

    @Transactional
    public void deletar(Long id) {
        Categoria c = buscar(id);
        repo.delete(c);
    }

    public CategoriaResponseDto toResponse(Categoria c) {
        CategoriaResponseDto r = new CategoriaResponseDto();
        r.setId(c.getId());
        r.setNome(c.getNome());
        r.setDescricao(c.getDescricao());
        return r;
    }
}