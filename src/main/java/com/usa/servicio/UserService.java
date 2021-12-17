
package com.usa.servicio;

import com.usa.modelo.User;
import com.usa.repositorio.UserRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author Rodrigo
 */
@Service
public class UserService {


    /**
     *
     * @param user
     */
     @Autowired
    private UserRepositorio userRepository;
    /**
     *
     * @param user
     */
    public List<User> getAll() {
        return userRepository.getAll();
    }
    /**
     *
     * @param id
     */
    public Optional<User> getUserById(int id) {
        return userRepository.getUserById(id);
    }

    /**
     *
     * @param user
     */
    public User registrar(User user) {
        if (user.getId() == null) {
            if (emailExists(user.getEmail()) == false) {
                return userRepository.save(user);
            } else {
                return user;
            }
        } else {
            return user;
        }
    }
    /**
     *
     * @param email
     */
    public boolean emailExists(String email){

        Optional<User> usuarios = userRepository.emailExists(email);

        if (usuarios.isEmpty()){

            return false;}

        else{


            return true;}

    }


    /**
     *
     * @param email
     * @param password
     */
    public User autenticarUsuario(String email, String password) {
        Optional<User> usuario = userRepository.autenticarUsuario(email, password);

        if (usuario.isEmpty()) {
            return new User();
        } else {
            return usuario.get();
        }
    }

    /**
     *
     * @param user
     * @return
     */
    public User update(User user){

        if(user.getId()!=null){
            Optional<User> userExist = userRepository.getUserById(user.getId());
            if(userExist.isPresent()){
                if(user.getIdentification()!=null){
                    userExist.get().setIdentification(user.getIdentification());
                }
                if(user.getName()!=null){
                    userExist.get().setName(user.getName());
                }
                if (user.getBirthtDay()!=null){
                    userExist.get().setBirthtDay(user.getBirthtDay());
                 }
               if (user.getMonthBirthtDay()!=null){
                  userExist.get().setMonthBirthtDay(user.getMonthBirthtDay());
               }

                if(user.getAddress()!=null){
                    userExist.get().setAddress(user.getAddress());
                }
                if(user.getCellPhone()!=null){
                    userExist.get().setCellPhone(user.getCellPhone());
                }
                if(user.getEmail()!=null){
                    userExist.get().setEmail(user.getEmail());
                }
                if(user.getPassword()!=null){
                    userExist.get().setPassword(user.getPassword());
                }
                if(user.getZone()!=null){
                    userExist.get().setZone(user.getZone());
                }
                if(user.getType()!=null){
                    userExist.get().setType(user.getType());
                }
                return userRepository.save(userExist.get());
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    /**
     *
     * @param  id
     * @return
     */
    public Integer deleteById(Integer id){
        Optional<User> user = userRepository.getUserById(id);
        if(user.isPresent()){
            userRepository.deleteById(id);
            return null;
        }else{
            return id;
        }
    }

    /**
     *
     * @param user
     * @return
     */
    public User save(User user){

        if(user.getIdentification() == null || user.getName() == null || user.getAddress() == null
                || user.getCellPhone() == null || user.getEmail() == null || user.getPassword() == null
                || user.getZone() == null || user.getType() == null){

            return user;

        }else{

            Optional<User> existUser = userRepository.getNPEPSI(user.getIdentification(), user.getCellPhone(), user.getEmail(), user.getPassword(),user.getName());
            if(existUser.isEmpty()){

                return userRepository.save(user);
            }
            else{

                return user;

            }

        }
    }
    /**
     *
     * @param monthBirthtDay
     */


    public List<User> birthtDayList(String monthBirthtDay) {
        return userRepository.birthtDayList(monthBirthtDay);
    }


}
