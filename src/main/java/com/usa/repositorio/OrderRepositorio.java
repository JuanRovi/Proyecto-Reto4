package com.usa.repositorio;

import com.usa.interfaces.InterfaceOrder;
import com.usa.modelo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;


@Repository
public class OrderRepositorio {

    @Autowired
    private InterfaceOrder interfaceOrder;

    public List<Order> getAll(){
        return interfaceOrder.findAll();
    }

    public Optional<Order> getOrder(int id){
        return interfaceOrder.findById(id);
    }

    public Order save(Order order) {
        return interfaceOrder.save(order);
    }

    public void update(Order order){
        interfaceOrder.save(order);
    }

    public void delete(Order order){
        interfaceOrder.delete(order);
    }

    public List<Order> getOrderByZone(String zone){
        return interfaceOrder.findBySalesManZone(zone);
    }

    public List<Order> getBySalesManId(Integer id){
        return interfaceOrder.findBySalesManId(id);
    }

    public List<Order> getBySalesManIdAndStatus(Integer id, String status){
        return interfaceOrder.findBySalesManIdAndStatus(id, status);
    }

    public List<Order> getByRegisterDayAndSalesManId(String registerDay, Integer id){
        try {
            return interfaceOrder.findByRegisterDayAndSalesManId(new SimpleDateFormat("yyyy-MM-dd").parse(registerDay), id);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }


}
