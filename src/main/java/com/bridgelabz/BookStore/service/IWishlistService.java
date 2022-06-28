package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.dto.MyWishlistDTO;
import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.model.MyCart;
import com.bridgelabz.BookStore.model.MyWishList;

import java.util.List;

public interface IWishlistService {

    List<MyWishList> getMyWhishlist();

    MyWishList addBookToMyWhishlistUsingName(String name, MyWishlistDTO myWishlistDTO);

    void deleteBookFromMyWishlist(String name);

    MyCart addToMyCartUsingBookName(String name, MyCartDTO myCartDTO);
}
