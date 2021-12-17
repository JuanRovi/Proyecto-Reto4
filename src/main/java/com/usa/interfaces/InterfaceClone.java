
package com.usa.interfaces;


import com.usa.modelo.Clone;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 *
 * @author Rodrigo
 */
public interface InterfaceClone extends MongoRepository<Clone, String> {

    void deleteById(Integer id);

    Optional<Clone> findById(int id);
}
