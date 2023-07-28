package com.guilherme.bookstore.domain;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Livro {

    @EqualsAndHashCode.Include
    private Integer id;

    private String titulo;
    private String nome_autor;
    private String texto;

    private Categoria categoria;

}
