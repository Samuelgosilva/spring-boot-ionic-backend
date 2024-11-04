package com.samuelgoncalves.projetomc.services;

import com.samuelgoncalves.projetomc.domain.Cliente;
import com.samuelgoncalves.projetomc.repositories.ClienteRepository;
import com.samuelgoncalves.projetomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    public Cliente buscarId(Integer id){
        Optional<Cliente> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: "
                        + id
                        + ", Tipo: "
                        + Cliente.class.getName())
        );
    }
}
