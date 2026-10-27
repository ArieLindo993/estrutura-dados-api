package com.api.spring.controllers;

import com.api.spring.entidades.Categoria;
import com.api.spring.service.CategoriaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {


    private final CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping("/salvar-categoria")
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvar(categoria);
    }

    @GetMapping("/listar-categorias")
    public List<Categoria> listarCategorias() {
        return categoriaService.buscarTodasCategorias();
    }

    @GetMapping("/buscar-categoria-por-id/{id}")
    public Categoria buscarCategoriaPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id);
    }

    @PutMapping("/atualizar-categoria/{id}")
    public Categoria atualizarCategoria(@PathVariable Long id, @RequestBody Categoria categoria) {
        return categoriaService.atualizar(categoria, id);
    }

    @DeleteMapping("/deletar-categoria/{id}")
    public void deletarCategoria(@PathVariable Long id) {
        categoriaService.deletar(id);
    }
}
