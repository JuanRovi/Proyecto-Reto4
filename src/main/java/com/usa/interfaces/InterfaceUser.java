
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
     Optional<User> findByEmail(String email);
     Optional<User> findByEmailAndPassword(String email, String password);
     Optional<User> findByNameOrEmail(String name, String email);
}
