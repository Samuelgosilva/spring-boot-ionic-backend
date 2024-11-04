package com.samuelgoncalves.projetomc.services;

import com.samuelgoncalves.projetomc.domain.Categoria;
import com.samuelgoncalves.projetomc.repositories.CategoriaRepository;
import com.samuelgoncalves.projetomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public Categoria buscarId(Integer id){
        Optional<Categoria> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                        "Objeto não encontrado! Id: "
                        + id
                        + ", Tipo: "
                        + Categoria.class.getName())
        );
    }

    public Categoria insert(Categoria obj){
        obj.setId(null);
        return repo.save(obj);
    }
}
