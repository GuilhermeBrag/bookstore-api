package com.guilherme.bookstore.service;

import com.guilherme.bookstore.Dtos.CategoriaDTO;
import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;
    public Categoria findById(Integer id) {
        Optional<Categoria> obj = categoriaRepository.findById(id);
         return obj.orElseThrow(() -> new ObjectNotFoundException(
                 "Objeto não encontrado! Id:" + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return categoriaRepository.save(obj);
    }


    public Categoria update(Integer id, CategoriaDTO objDTO) {
        Categoria obj = findById(id);
        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());
        return categoriaRepository.save(obj);
    }

    public void delete(Integer id) {
        findById(id);

        try {
            categoriaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e) {
            throw new
                    com.guilherme.bookstore.service.exceptions.DataIntegrityViolationException(
                            "Categoria não pode ser deletada! Possui livros associados");
        }
    }

}
