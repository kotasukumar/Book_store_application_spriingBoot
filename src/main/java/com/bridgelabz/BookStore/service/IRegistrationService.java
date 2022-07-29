package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.RegistrationDTO;
import com.bridgelabz.BookStore.model.Registration;

import java.util.List;

public interface IRegistrationService {

    Registration addUser(RegistrationDTO registrationDTO);

    List<Registration> getAllUser();

    void deleteUser(int id);

    Registration updateUser(int id, RegistrationDTO registrationDTO);

    Registration getUserById(int id);
}
