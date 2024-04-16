package com.efashionshop.service;

import com.efashionshop.config.JwtProvider;
import com.efashionshop.exception.UserException;
import com.efashionshop.model.User;
import com.efashionshop.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class StartupService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostConstruct
    public void createAdmin(){




        String email= "admin@gmail.com";
        String password= "admin123";
        String firstName= "ad";
        String lastName= "min";

        User isEmailExist=userRepository.findByEmail(email);

        if(isEmailExist!=null) {
            return;
        }

        User createdUser=new User();
        createdUser.setEmail(email);
        createdUser.setPassword(passwordEncoder.encode(password));
        createdUser.setFirstName(firstName);
        createdUser.setLastName(lastName);
        createdUser.setRole("ADMIN");

        System.out.println("admin created");

        userRepository.save(createdUser);
    }
}
