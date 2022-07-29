package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.LoginDTO;
import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.service.ILogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/addressbook/login")
public class LoginController {

    @Autowired
    private ILogin iLogin;

    /*
     * Ability to take name and password from body and checking the data is existing the database or not
     * And need to return true if data exist and false if not
     * */
    @PostMapping
    public ResponseEntity<ReasponseDTO> checkLogin(@RequestBody LoginDTO loginDTO){
        ReasponseDTO reasponseDTO =  new ReasponseDTO("post call success", iLogin.loginCheck(loginDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
