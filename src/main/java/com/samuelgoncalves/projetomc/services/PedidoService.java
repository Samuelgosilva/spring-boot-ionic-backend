package com.samuelgoncalves.projetomc.services;

import com.samuelgoncalves.projetomc.domain.Pedido;
import com.samuelgoncalves.projetomc.repositories.PedidoRepository;
import com.samuelgoncalves.projetomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository repo;

    public Pedido findById(Integer id){
        Optional<Pedido> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: "
                        + id
                        + ", Tipo: "
                        + Pedido.class.getName())
        );
    }
}
