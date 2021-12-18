
package com.usa.repositorio;

import com.usa.interfaces.InterfaceClone;
import com.usa.modelo.Clone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rodrigo
 */
@Repository
public class CloneRepositorio {
    @Autowired
    private InterfaceClone repository;

    public List<Clone> getAll(){
        return repository.findAll();
    }

    public Optional<Clone> getClone(int id){
        return repository.findById(id);
    }

    public Clone save(Clone clone){
        return repository.save(clone);
    }

    public void update(Clone clone){
        repository.save(clone);
    }

    public void delete(Clone clone){
        repository.delete(clone);
    }
}
