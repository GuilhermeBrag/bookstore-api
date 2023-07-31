package com.guilherme.bookstore.service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBservice {

    @Autowired
    private CategoriaRepository categoriaRepository;
    @Autowired
    private LivroRepository livroRepository;
    public void instanciaBaseDeDados() {

        Categoria cat1 = new Categoria(null,"Informatica","Livros de informatica");
        Categoria cat2 = new Categoria(null,"Autoajuda","Livros de autoajuda");
        Categoria cat3 = new Categoria(null,"Biografias","Livros de Biografias");

        Livro l1 = new Livro(null, "Clean Code","Robert Martin","lorem ipsum", cat1);
        Livro l2 = new Livro(null, "A Sutil Arte","Mark Manson","lorem ipsum", cat2);
        Livro l3 = new Livro(null, "A Marca da Vitória","Phil Knight","lorem ipsum", cat3);

        cat1.getLivros().addAll(Arrays.asList(l1));
        cat2.getLivros().addAll(Arrays.asList(l2));
        cat3.getLivros().addAll(Arrays.asList(l3));

        this.categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.livroRepository.saveAll(Arrays.asList(l1,l2,l3));

    }

}
