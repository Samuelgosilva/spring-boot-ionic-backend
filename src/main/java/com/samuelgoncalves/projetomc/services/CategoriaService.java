package com.samuelgoncalves.projetomc.services;

import com.samuelgoncalves.projetomc.domain.Categoria;
import com.samuelgoncalves.projetomc.repositories.CategoriaRepository;
import com.samuelgoncalves.projetomc.services.exceptions.DataIntegrityException;
import com.samuelgoncalves.projetomc.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public Categoria findById(Integer id){
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

    public Categoria update(Categoria obj){
        findById(obj.getId());
        return repo.save(obj);
    }

    public void delete(Integer id){
        findById(id);
        try{
        repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
        }
    }

    public List<Categoria> findAll(){
        return repo.findAll();
    }

    //paginação de dados
    public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        return repo.findAll(pageRequest);

    }
}
