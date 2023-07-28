package com.guilherme.bookstore.domain;

import lombok.*;

import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Categoria {

    @EqualsAndHashCode.Include
    private Integer id;
    private String nome;
    private String descricao;

    private List<Livro> livros = new ArrayList<>();


}
