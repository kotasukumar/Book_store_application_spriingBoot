package com.bridgelabz.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    /*Declaring all DTO for login*/
    public String userName;
    public String password;
}

