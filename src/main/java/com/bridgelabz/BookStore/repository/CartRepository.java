package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.model.MyCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<MyCart, String> {

    MyCart findByBookName(String name);

    MyCart findById(int id);

    @Query(value = "SELECT * from my_cart as u where u.cart_id = :id", nativeQuery = true)
    List<MyCart> findByCartId(int id);
}
