package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.model.MyCart;

import java.util.List;

public interface ICartService {

    MyCart addToMyCartUsingBookName(String name, MyCartDTO myCartDTO);

    void deleteBookInMyCartUsingBookName(String name);

    void removeBookInMyCartUsingBookNameAndQuantity(String name, int quantity);

    List<MyCart> getMyCartList();
}
