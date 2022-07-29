package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.LoginDTO;
import com.bridgelabz.BookStore.model.Login;
import com.bridgelabz.BookStore.model.Registration;
import com.bridgelabz.BookStore.repository.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService implements ILogin{

    @Autowired
    RegistrationRepository registrationRepository;

    /*Ability to check user exiting or not*/
    @Override
    public Login loginCheck(LoginDTO loginDTO) {
        Registration registration = registrationRepository.findByUserName(loginDTO.userName);
        if (registration != null) {
            if (registration.getPassword().equals(loginDTO.getPassword())) {
                Login login = Login.Build(loginDTO.getUserName(), loginDTO.getPassword(), true, registration.getId());
                return login;
            } else {
                return Login.Build(loginDTO.getUserName(), loginDTO.getPassword(), false, registration.getId());
            }
        }else {
            return Login.Build(loginDTO.getUserName(), loginDTO.getPassword(), false, registration.getId());
        }
    }
}
