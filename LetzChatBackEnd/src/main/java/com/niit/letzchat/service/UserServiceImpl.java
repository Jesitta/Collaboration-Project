package com.niit.letzchat.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niit.letzchat.dao.UserDAO;
import com.niit.letzchat.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
     
	@Autowired
	private UserDAO userDAO;
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<User> users;
     
    static{
        users= populateDummyUsers();
    }
 
   


	public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }
     
    public User findByName(String name) {
        for(User user : users){
            if(user.getEmail().equalsIgnoreCase(name)){
                return user;
            }
        }
        return null;
    }
     
    public void saveUser(User user) {
        user.setId(counter.incrementAndGet());
        users.add(user);
    }
    
    public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }
 
    public void deleteUserById(long id) {
         
        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getEmail())!=null;
    }
     
    public void deleteAllUsers(){
        users.clear();
    }
 
    private static List<User> populateDummyUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }
    /*new*/
    public void saveOrUpdate(User user){
        userDAO.saveOrUpdate(user);
        }
    public List<User> findAllUsers() {
        List<User> users=userDAO.list();
           return users;
       }
        
     



}