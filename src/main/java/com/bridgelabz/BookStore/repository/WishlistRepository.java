package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.MyCart;
import com.bridgelabz.BookStore.model.MyWishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<MyWishList, String> {

    MyWishList findByBookName(String name);
}
