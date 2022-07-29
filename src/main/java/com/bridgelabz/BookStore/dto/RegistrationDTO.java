package com.bridgelabz.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationDTO {

    /*Declaring DTO for user registration*/
    public String userName;
    public String emailID;
    public String password;
}
