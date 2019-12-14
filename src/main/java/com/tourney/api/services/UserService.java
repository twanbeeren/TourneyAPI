package com.tourney.api.services;

import com.tourney.api.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tourney.api.repositories.UserRepository;

import java.util.List;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;



    public void create(User u) {
        userRepository.save(u);
    }

    public boolean login(User u){
        boolean succes;

        try{
            //Check if this works
            succes = userRepository.findByEmail(u.getEmail()).isPresent();
        }
        catch (Exception ex){
            succes = false;
        }

        return succes;
    }
}
