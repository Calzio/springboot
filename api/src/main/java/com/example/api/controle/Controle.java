package com.example.api.controle;

import org.springframework.web.bind.annotation.RestController;

import com.example.api.modelo.Pessoa;
import com.example.api.repositorio.Repositorio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;





@RestController
public class Controle {

    //depois de fazer repositorio
    @Autowired
    private Repositorio acao;

    @PostMapping("/api")
    public Pessoa cadastrear(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }
    
    @GetMapping("/api")
    public List<Pessoa> selecionar() {
        return acao.findAll();
    }
    
    @GetMapping("/api/{codigo}")
    public Pessoa selecionarPeloCodigo(@PathVariable int codigo) {
        return acao.findByCodigo(codigo);
    }
    
    @PutMapping("/api")
    public Pessoa editar(@RequestBody Pessoa obj) {
        return acao.save(obj);
    }

    @DeleteMapping("/api/{codigo}")
    public void remover(@PathVariable int codigo){
    Pessoa obj = selecionarPeloCodigo(codigo);
    acao.delete(obj);    
        
    }
    
    //inicializar
    @GetMapping("")
    public String mensgem(){
        return "Olá mundo";
    }

    @GetMapping("/boasVindas")
    public String bemVIndo() {
        return "Seja bem-vindo!";
    }

    @GetMapping("/bemVindo/{nome}")
    public String bemVindoNome(@PathVariable String nome) {
        return "Seja bem-vindo(a) "+nome;
    }
    
    @PostMapping("/pessoa")
    public Pessoa pessoa(@RequestBody Pessoa p) {
        
        return p;
    }
    

}
