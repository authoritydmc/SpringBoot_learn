package com.authoritydmc.learn.Services;

import com.authoritydmc.learn.Entity.User;
import com.authoritydmc.learn.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

        private  UserRepository userRepository;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers()
    {
        return userRepository.findAll();
    }

    public User insertUser(User user)
    {
        if(user.getId()!=null)
        if (userRepository.existsById(user.getId()))
            return null;
        userRepository.save(user);
        return user;
    }
    public  User updateuser(User updatedUser,Long id)
    {

    User userFound=findUserById(id);
    if (userFound==null) return null;

//    update Each details except id;;;;;

        updatedUser.setId(id);
        userRepository.save(updatedUser);
        return updatedUser;
    }

    public User findUserById(Long id)
    {
        return userRepository.findById(id).orElse(null);
    }

    public boolean deleteUser(Long id) {

        if (userRepository.existsById(id))
        {
            userRepository.deleteById(id);
            return true;
        }
        return  false;
    }
}
