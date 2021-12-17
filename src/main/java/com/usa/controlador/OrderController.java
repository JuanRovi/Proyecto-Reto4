
package com.usa.controlador;


import com.usa.modelo.Order;
import com.usa.servicio.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;



@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})

public class OrderController {
     @Autowired
    private OrderService service;

    
    /**
     * 
     * @return 
     */
    @GetMapping("/all")
    public List<Order> getOrder() {

        return service.getAll();

    }
    
    @GetMapping("/{id}")
    public Order getById(@PathVariable("id") Integer id){
        
        return service.getById(id);
    
    }
    
    
    /**
     * 
     * @param clone
     * @return 
     */
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order save(@RequestBody Order order){
        System.out.println(order);
    return service.save(order);
    
    }
    

    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Integer delete(@PathVariable Integer id){
    
       return  service.deleteOrder(id);
    
    }

    
    @GetMapping("/zona/{zone}")
    public List<Order> getByZone(@PathVariable String zone){
        return service.getZone(zone);
    
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order order){
        return service.update(order);
    
    }

    @GetMapping("/salesman/{id}")
    public List<Order> getBySalesManId(@PathVariable Integer id){

        return service.findBySalesManId(id);

    }


    @GetMapping("/date/{fecha}/{id}")
    public List<Order> getDate (@PathVariable String fecha,@PathVariable Integer id) throws ParseException {

        return service.getRegisterDay(fecha,id);

    }


    @GetMapping("/state/{state}/{id}")
    public List<Order> getStatusById (@PathVariable("state") String state,@PathVariable("id") Integer id){

        return service.getStatusById(state, id);

    }
}
