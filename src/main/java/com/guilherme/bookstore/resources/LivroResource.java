package com.guilherme.bookstore.resources;

import com.guilherme.bookstore.Dtos.LivroDTO;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.LivroRepository;
import com.guilherme.bookstore.service.LivroService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = livroService.update(id,obj);

        return ResponseEntity.ok().body(newObj);
    }
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Livro> updatePatch(@PathVariable Integer id, @RequestBody Livro obj){
        Livro newObj = livroService.update(id,obj);

        return ResponseEntity.ok().body(newObj);
    }


}