
package com.usa.interfaces;

import com.usa.modelo.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rodrigo
 */
public interface InterfaceUser extends MongoRepository<User, Integer> {
     /**
      *
      * @param name
      * @return
      */
     Optional<User> findByName(String name);
     /**
      *
      * @param email
      * @return
      */
     Optional<User> findByEmail(String email);
     /**
      *
      * @param name
      * @param email
      */

     Optional<User>findByNameOrEmail(String name,String email);
     /**
      *
      * @param email
      * @param password
      */

     Optional<User> findByEmailAndPassword(String email,String password);
     /**
      *
      * @param Identification
      * @param cellPhone
      * @param email
      * @param password
      * @param Name
      */

     Optional<User> findByIdentificationAndCellPhoneAndEmailAndPasswordAndName(String Identification,String cellPhone, String email, String password, String Name);


     List<User> findByMonthBirthtDay(String monthBirthtDay);

     List<User> findBybirthtDay(Date date);
}
