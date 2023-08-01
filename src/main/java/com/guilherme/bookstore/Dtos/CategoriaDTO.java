package com.guilherme.bookstore.Dtos;

import com.guilherme.bookstore.domain.Categoria;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@NoArgsConstructor
@Getter
@Setter
public class CategoriaDTO implements Serializable {


    @Serial
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String descricao;

    public CategoriaDTO(Categoria obj) {
        this.id = obj.getId();
        this.nome = obj.getNome();
        this.descricao = obj.getDescricao();
    }



}
