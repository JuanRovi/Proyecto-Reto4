package com.usa.servicio;

import com.usa.modelo.Order;
import com.usa.repositorio.OrderRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private OrderRepositorio orderRepository;

    public List<Order> getAll(){

        return orderRepository.getAll();

    }

    public Order save(Order order){
        Optional<Order> orderExist=orderRepository.getOrderById(order.getId());

        if (orderExist.isEmpty()){

            return orderRepository.save(order);
        }
        else{
            return order;
        }
    }

    public Order update(Order order){

        if(order.getId() == null){

            return order;

        }else{
            Optional<Order> orderExist = orderRepository.getOrderById(order.getId());
            if(orderExist.isPresent()){
                if(order.getStatus() != null){

                    orderExist.get().setStatus(order.getStatus());

                }
                return orderRepository.save(order);
            }else{

                return order;

            }

        }



    }


    public Integer deleteOrder(Integer id){
        Optional<Order> orderExist = orderRepository.getOrderById(id);

        if(!orderExist.isEmpty() ){

            orderRepository.deleteOrder(id);
            return null;
        }
        else{
            return id;
        }
    }


    public Order getById(Integer id){

        Optional<Order> orderExist= orderRepository.getOrderById(id);
        if(orderExist.isPresent()){

            return orderExist.get();
        }
        else{

            return new Order();
        }
    }

    public List<Order> getZone(String country){

        return orderRepository.getZone(country);

    }

    public List<Order> getStatus(String zone){

        return orderRepository.getStatus(zone);

    }

    public List<Order> findBySalesManId(Integer id) {

        return orderRepository.findBySalesManId(id);

    }

    public List<Order> getStatusById(String status, Integer id) {

        return orderRepository.getStatusById(status, id);

    }

    public List<Order> getRegisterDay(String dateStr, Integer id) {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();

        Criteria dateCriteria = Criteria.where("registerDay")
                .gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
                .lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
                .and("salesMan.id").is(id);
        query.addCriteria(dateCriteria);

        List<Order> orders = mongoTemplate.find(query, Order.class);
        System.out.println(orders);
        return orders;

    }
}
