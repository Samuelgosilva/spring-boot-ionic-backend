package com.samuelgoncalves.projetomc.resources;

import com.samuelgoncalves.projetomc.domain.Cliente;
import com.samuelgoncalves.projetomc.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

    @Autowired
    ClienteService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cliente> findById(@PathVariable Integer id){ //retorna busca por ID
        Cliente obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
