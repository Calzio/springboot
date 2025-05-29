package com.example.api.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.api.modelo.Pessoa;

public interface Repositorio extends CrudRepository<Pessoa, Integer>{
    //mas tem que importar no maven>dependencies>+ data-jpa e o mysql

    List<Pessoa> findAll();

    Pessoa findByCodigo(int id);    
}
