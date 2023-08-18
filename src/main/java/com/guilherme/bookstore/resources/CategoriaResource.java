package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.Dtos.CategoriaDTO;
import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.service.CategoriaService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
        Categoria obj = categoriaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaService.findAll();
        List<CategoriaDTO> listDTO = list.stream()
                .map(CategoriaDTO::new).toList();

        return ResponseEntity.ok().body(listDTO);
    }

    @PostMapping("/create")
    public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj) {
        obj = categoriaService.create(obj);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<CategoriaDTO> update(@Valid @PathVariable Integer id, @RequestBody CategoriaDTO objDTO) {
        Categoria newObj = categoriaService.update(id, objDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        categoriaService.delete(id);
        return ResponseEntity.noContent().build();
    }

}


