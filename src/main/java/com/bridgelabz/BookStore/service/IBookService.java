package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.BookDTO;
import com.bridgelabz.BookStore.model.BookStoreData;

import java.util.List;

public interface IBookService {

    List<BookStoreData> getBookList();

    BookStoreData createBook(BookDTO bookDTO);

    BookStoreData updateBookById(int id, BookDTO bookDTO);

    void deleteBookById(int id);

    BookStoreData searchBookByName(String name);

    List<BookStoreData> sortPrizeHighToLow();

    List<BookStoreData> sortPrizeLowToHigh();

    BookStoreData searchBookById(int id);
}
