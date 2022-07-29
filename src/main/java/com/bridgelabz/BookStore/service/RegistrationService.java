package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.RegistrationDTO;
import com.bridgelabz.BookStore.model.Registration;
import com.bridgelabz.BookStore.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService implements IRegistrationService{

    @Autowired
    private RegistrationRepository registrationRepository;

    /*Ability to add the user by taking data from requisite body*/
    @Override
    public Registration addUser(RegistrationDTO registrationDTO) {
        Registration registration = Registration.Built(0, registrationDTO.getUserName(), registrationDTO.getEmailID(), registrationDTO.getPassword());
        return registrationRepository.save(registration);
    }

    /*Ability to return all the users in the database*/
    @Override
    public List<Registration> getAllUser() {
        return registrationRepository.findAll();
    }

    /*Ability to delete the user by using id*/
    @Override
    public Registration getUserById(int id){
        return registrationRepository.findById(id);
    }

    /*Ability to delete the user by id*/
    @Override
    public void deleteUser(int id) {
        registrationRepository.delete(this.getUserById(id));

    }

    /*Ability to update the user by using id*/
    @Override
    public Registration updateUser(int id, RegistrationDTO registrationDTO) {
        List<Registration> registrationList = this.getAllUser();
        for (Registration registration : registrationList){
            if (registration.getId() == id){
                registration.setUserName(registrationDTO.getUserName());
                registration.setEmailID(registrationDTO.getEmailID());
                registration.setPassword(registrationDTO.getPassword());
                return registrationRepository.save(registration);
            }
        }
        return null;
    }
}