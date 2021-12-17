package com.usa.repositorio;

import com.usa.interfaces.InterfaceOrder;
import com.usa.modelo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Repository
public class OrderRepositorio {

    @Autowired
    private InterfaceOrder interfaceOrder;

    public List<Order> getAll() {

        return (List<Order>) interfaceOrder.findAll();
    }

    public Optional<Order> getOrderById(Integer id){

        return interfaceOrder.findById(id);

    }

    public Order save(Order order) {

        return interfaceOrder.save(order);
    }

    public void deleteOrder(Integer id){

        interfaceOrder.deleteById(id);

    }

    public List<Order> getZone(String country){

        return interfaceOrder.findByZone(country);

    }

    public List<Order> getStatus(String status){

        return interfaceOrder.findByStatus(status);

    }

    public List<Order> findBySalesManId(Integer id){


        return interfaceOrder.findBySalesMan_Id(id);

    }

    public List<Order> getDate(Date fecha, Integer id){

        return interfaceOrder.findByRegisterDayAndSalesMan_id(fecha,id);

    }

    public List<Order> getStatusById(String status, Integer id){

        return interfaceOrder.findByStatusAndSalesMan_id(status, id);

    }



}
