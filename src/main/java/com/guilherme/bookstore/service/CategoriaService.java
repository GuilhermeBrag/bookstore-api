package com.guilherme.bookstore.service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
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



}
