package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.BookStoreData;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<BookStoreData, String> {
    BookStoreData findById(int id);

    BookStoreData findByBookName(String name);

    @Query(value = "SELECT * from book_store_data ORDER BY prize", nativeQuery = true)
    List<BookStoreData> sortBookByAsc();

    @Query(value = "SELECT * from book_store_data ORDER BY prize DESC ", nativeQuery = true)
    List<BookStoreData> sortBookByDes();
}
