package com.bridgelabz.BookStore.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserRegistrationService implements UserDetailsService {


    /*passing user name and password*/
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("sukumar", "123", new ArrayList<>());
    }
}
