package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.model.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<MyCart, String> {

    MyCart findByBookName(String name);
}
