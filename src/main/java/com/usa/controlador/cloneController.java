
package com.usa.controlador;



import com.usa.modelo.Clone;
import com.usa.servicio.CloneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/clone")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class cloneController {
    
    @Autowired
    private CloneService service;

    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Clone> getClone() {

        return service.getAll();

    }
    
    @GetMapping("/{id}")
    public Optional<Clone> getById(@PathVariable int id){
    
        return service.getById(id);
    
    }
    
    
    /**
     * 
     * @param clone
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone save(@RequestBody Clone clone){
        System.out.println(clone);
    return service.save(clone);
    
    }
    
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Clone update(@RequestBody Clone clone){
    
    return service.update(clone);
    
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable Integer id){
    
       return  service.deleteClone(id);
    
    }
    
}
