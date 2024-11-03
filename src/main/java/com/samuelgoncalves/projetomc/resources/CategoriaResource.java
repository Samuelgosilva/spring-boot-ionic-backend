package com.samuelgoncalves.projetomc.resources;

import com.samuelgoncalves.projetomc.domain.Categoria;
import com.samuelgoncalves.projetomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){ //retorna busca por ID
        Categoria obj = service.buscarId(id);
        return ResponseEntity.ok().body(obj);
    }
}
