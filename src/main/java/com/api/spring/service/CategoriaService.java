package com.api.spring.service;

import com.api.spring.entidades.Categoria;
import com.api.spring.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
//@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria salvar(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Categoria categoriaAtualizada, Long id) {
       Categoria categoriaSalva = buscarPorId(id);
        BeanUtils.copyProperties(categoriaAtualizada, categoriaSalva, "id");
       return categoriaRepository.save(categoriaSalva);
    }

    public Categoria buscarPorId(Long id) {
        return categoriaRepository.findById(id).orElseThrow(() ->
                new RuntimeException("Categoria não encontrada!"));
    }

    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    public List<Categoria> buscarTodasCategorias() {
        return categoriaRepository.findAll();
    }
}
