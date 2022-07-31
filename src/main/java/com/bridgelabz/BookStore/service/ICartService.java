package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.model.MyCart;

import java.util.List;

public interface ICartService {

    MyCart addToMyCartUsingId(int id, int userID);

    void deleteBookInMyCartUsingId(int id);

    List<MyCart> getMyCartList();

    MyCart increaseBookQuantityByOne(int id);

    MyCart decreaseBookQuantityByOne(int id);

    List<MyCart> getCartByUserId(int id);

    void emptyCart(int userID);

    float getCartPrice(int userID);
}
