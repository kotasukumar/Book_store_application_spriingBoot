package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.LoginDTO;
import com.bridgelabz.BookStore.model.Login;

public interface ILogin {
    Login loginCheck(LoginDTO loginDTO);
}

