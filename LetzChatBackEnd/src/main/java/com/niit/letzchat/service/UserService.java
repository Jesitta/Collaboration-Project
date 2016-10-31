package com.niit.letzchat.service;

import java.util.List;

import com.niit.letzchat.model.User;

public interface UserService {
	User findById(long id);
    
    User findByName(String name);
     
    void saveUser(User user);
     
    void updateUser(User user);
     
    void deleteUserById(long id);
 

     
    void deleteAllUsers();
     
    public boolean isUserExist(User user);

    /*new*/
    public void saveOrUpdate(User user);
   
    List<User> findAllUsers(); 
}
