package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.dto.RegistrationDTO;
import com.bridgelabz.BookStore.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/registration")
public class RegistrationController {

    @Autowired
    IRegistrationService iRegistrationService;

    /*Ability to return all the users in the database*/
    @GetMapping("/getallusers")
    public ResponseEntity<ReasponseDTO> getALlUsers(){
        ReasponseDTO reasponseDTO =  new ReasponseDTO("Get call is success", iRegistrationService.getAllUser());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*Ability to add the user by taking data from requisite body*/
    @PostMapping("/adduser")
    public ResponseEntity<ReasponseDTO> addUser(@RequestBody RegistrationDTO registrationDTO){
        ReasponseDTO reasponseDTO = new  ReasponseDTO("Post call success", iRegistrationService.addUser(registrationDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*Ability to update the user by using id*/
    @PutMapping("/update/{id}")
    public ResponseEntity<ReasponseDTO> updateUser(@PathVariable ("id") int id, @RequestBody RegistrationDTO registrationDTO){
        ReasponseDTO reasponseDTO = new  ReasponseDTO("put method success", iRegistrationService.updateUser(id, registrationDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*Ability to delete the user by id*/
    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<ReasponseDTO>deleteUser(@PathVariable ("id") int id){
        iRegistrationService.deleteUser(id);
        ReasponseDTO reasponseDTO = new  ReasponseDTO("Delete method success", "Deleted user id is:"  + id);
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*Ability to return particular user details*/
    @GetMapping("/getuserbyid/{id}")
    public ResponseEntity<ReasponseDTO> getUserById(@PathVariable ("id") int id){
        ReasponseDTO reasponseDTO = new  ReasponseDTO("Get call by id success", iRegistrationService.getUserById(id));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}

