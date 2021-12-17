package com.usa.interfaces;

import com.usa.modelo.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface InterfaceOrder extends MongoRepository<Order,Integer> {

    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);

    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);

    List<Order> findByRegisterDayAndSalesMan_id(Date fecha, Integer id);

    List<Order> findBySalesMan_Id(Integer id);

    List<Order> findByStatusAndSalesMan_id(String status,Integer id);
}
