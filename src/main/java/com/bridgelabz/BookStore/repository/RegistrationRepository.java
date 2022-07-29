package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Declaring the class as repository for registration
public interface RegistrationRepository extends JpaRepository<Registration, String> {

    /*Finding user using id*/
    Registration findById(int id);

    /*Finding user by name*/
    Registration findByUserName(String userName);
}
