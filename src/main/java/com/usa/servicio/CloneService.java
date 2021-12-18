
package com.usa.servicio;

import com.usa.modelo.Clone;
import com.usa.repositorio.CloneRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rodrigo
 */
@Service
public class CloneService {
     @Autowired
    private CloneRepositorio cloneRepository ;

    public List<Clone> getAll(){
        return cloneRepository.getAll();
    }

    public Optional<Clone> getClone(int id){
        return cloneRepository.getClone(id);
    }

    public Clone save(Clone clone){
        if (clone.getId()== null){
            return clone;
        }
        return cloneRepository.save(clone);
    }

    public Clone update(Clone clone){
        if (clone.getId()!= null){
            Optional<Clone> cloneExist = cloneRepository.getClone(clone.getId());
            if (!cloneExist.isEmpty()){
                if (clone.getBrand()!= null){
                    cloneExist.get().setBrand(clone.getBrand());
                }
                if (clone.getProcesor()!= null){
                    cloneExist.get().setProcesor(clone.getProcesor());
                }
                if (clone.getOs()!= null){
                    cloneExist.get().setOs(clone.getOs());
                }
                if (clone.getDescription() != null){
                    cloneExist.get().setDescription(clone.getDescription());
                }
                if (clone.getMemory()!= null){
                    cloneExist.get().setMemory(clone.getMemory());
                }
                if (clone.getHardDrive()!= null){
                    cloneExist.get().setHardDrive(clone.getHardDrive());
                }

                cloneExist.get().setAvailability(clone.isAvailability());

                if (clone.getPrice()!= 0.0){
                    cloneExist.get().setPrice(clone.getPrice());
                }
                if (clone.getQuantity()!= 0){
                    cloneExist.get().setQuantity(clone.getQuantity());
                }
                if (clone.getPhotography()!= null){
                    cloneExist.get().setPhotography(clone.getPhotography());
                }
                cloneRepository.update(cloneExist.get());
                return cloneExist.get();
            } else {
                return clone;
            }
        } else {
            return clone;
        }
    }

    public boolean delete(int id){
        return getClone(id).map(clone -> {
            cloneRepository.delete(clone);
            return true;
        }).orElse(false);
    }
    
}
