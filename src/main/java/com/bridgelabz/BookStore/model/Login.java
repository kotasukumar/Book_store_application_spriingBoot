package com.bridgelabz.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class Login {
    /*Declaring data for login*/
    private String userName;
    private String password;
    private boolean result;
    private  int id;
}

