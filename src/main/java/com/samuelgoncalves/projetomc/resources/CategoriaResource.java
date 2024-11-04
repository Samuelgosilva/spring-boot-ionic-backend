package com.samuelgoncalves.projetomc.resources;

import com.samuelgoncalves.projetomc.domain.Categoria;
import com.samuelgoncalves.projetomc.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

    @Autowired
    CategoriaService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Integer id){ //retorna busca por ID
        Categoria obj = service.buscarId(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Void> insert(@RequestBody Categoria obj){
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(obj.getId()).toUri();
                return  ResponseEntity.created(uri).build();
    }
}
