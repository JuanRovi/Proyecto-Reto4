package com.usa;

import com.usa.interfaces.InterfaceClone;
import com.usa.interfaces.InterfaceOrder;
import com.usa.interfaces.InterfaceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoR3Application {

    @Autowired
    private InterfaceClone interfaceClone;

    @Autowired
    private InterfaceUser interfaceUser;

    @Autowired
    private InterfaceOrder interfaceOrder;


    public static void main(String[] args) {
        SpringApplication.run(ProyectoR3Application.class, args);

    }

    public void run(String... args) throws Exception{

        interfaceClone.deleteAll();
        interfaceUser.deleteAll();
        interfaceOrder.deleteAll();

    }

}
