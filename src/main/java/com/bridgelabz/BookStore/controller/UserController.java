/*
package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.model.Token;
import com.bridgelabz.BookStore.model.UserRegistration;
import com.bridgelabz.BookStore.service.UserRegistrationService;
import com.bridgelabz.BookStore.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserRegistrationService userRegistrationService;

    @Autowired
    private JWTUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

*/
/*Used to generate token
    * @Body: user registration details
    * @Return: token
    * *//*


    @PostMapping("/authenticate")
    public Token authenticate(@RequestBody @Valid UserRegistration userRegistration) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(userRegistration.getName(), userRegistration.getPassword()));
        }catch (BadCredentialsException e){
            throw  new Exception("Invalid credentials ", e);
        }

        final UserDetails userDetails = userRegistrationService.loadUserByUsername(userRegistration.getName());

        final String token = jwtUtility.generateToken(userDetails);
        return new Token(token);
    }

}

*/
