package com.samuelgoncalves.projetomc.resources;

import com.samuelgoncalves.projetomc.domain.Pedido;
import com.samuelgoncalves.projetomc.services.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/pedidos")
public class PedidoResource {

    @Autowired
    PedidoService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> findById(@PathVariable Integer id){ //retorna busca por ID
        Pedido obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
