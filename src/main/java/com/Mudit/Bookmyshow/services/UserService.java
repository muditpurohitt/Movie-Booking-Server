package com.Mudit.Bookmyshow.services;

import com.Mudit.Bookmyshow.model.User;
import com.Mudit.Bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User signup(String email, String password){
        //1.Check if user exists in the database
        Optional<User> user = userRepository.findByEmailId(email);

        //2.If yes, take to login page.
        if(user.isEmpty()){
            return login(email, password);
        }

        //3.If not, take to signup page(Create user object and save in the db,
        // save password after encryption- BYCRYPT ENCODER)

        User newUser = new User();
        newUser.setEmailid(email);

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        newUser.setPassword(bCryptPasswordEncoder.encode(password));

        User savedUser = userRepository.save(newUser);
        return savedUser;
    }
    public User login(String email, String password){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        Optional<User> optionalUser = userRepository.findByEmailId(email);
        User foundUser = optionalUser.get();

        if(bCryptPasswordEncoder.matches(password, foundUser.getPassword())){
            return foundUser;
        }
        return null;
    }
}
