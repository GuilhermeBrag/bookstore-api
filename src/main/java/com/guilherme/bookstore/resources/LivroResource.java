package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.Dtos.LivroDTO;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.LivroRepository;
import com.guilherme.bookstore.service.LivroService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/livros")
public class LivroResource {

    @Autowired
    private LivroRepository livroRepository;
    @Autowired
    private LivroService livroService;
    @GetMapping(value = "/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro obj = livroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria",defaultValue = "0") Integer id_cat) {
        List<Livro> list = livroService.findAll(id_cat);
        List<LivroDTO> listDTO= list.stream()
                .map(LivroDTO::new).toList();
       return ResponseEntity.ok().body(listDTO);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Livro> update( @PathVariable Integer id, @Valid @RequestBody Livro obj){
        Livro newObj = livroService.update(id,obj);

        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch( @PathVariable Integer id, @Valid @RequestBody Livro obj){
        Livro newObj = livroService.update(id,obj);

        return ResponseEntity.ok().body(newObj);
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestParam(value ="categoria",defaultValue = "0") Integer id_cat,
                                         @Valid @RequestBody Livro obj) {
        Livro newObj = livroService.create(id_cat,obj);
        URI uri = ServletUriComponentsBuilder.
                fromCurrentContextPath().path("livros/{id}")
                .buildAndExpand(newObj.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        livroService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
