package com.algaworks.algatransito.algatransito.api.controller;

import com.algaworks.algatransito.algatransito.model.domain.Proprietario;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProprietarioController {

    @GetMapping ("/proprietarios")
    public List<Proprietario> listar(){

        var proprietario1 = new Proprietario();
        proprietario1.setId(1L);
        proprietario1.setNome("João");
        proprietario1.setTelefone("11 99658-6574");
        proprietario1.setEmail("joao@hotmail.com");

        var proprietario2 = new Proprietario();
        proprietario2.setId(2L);
        proprietario2.setNome("Ana");
        proprietario2.setTelefone("11 94118-8574");
        proprietario2.setEmail("ana@hotmail.com");

        return Arrays.asList(proprietario1, proprietario2);

    }

}
