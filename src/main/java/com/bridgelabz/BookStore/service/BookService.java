package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.BookDTO;
import com.bridgelabz.BookStore.execption.BookNotFoundExecption;
import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;


    /*
    * @Return: list of books
    * */
    @Override
    public List<BookStoreData> getBookList() {
        return bookRepository.findAll();
    }

    /*
     * This post is used to add a book into the repository
     * variable: BookDTO
     * @Return: details of book that we added
     * */
    @Override
    public BookStoreData createBook(BookDTO bookDTO) {
        BookStoreData bookStoreData = BookStoreData.Build(0, bookDTO.getBookName(), bookDTO.getAuthorName(), bookDTO.getPrize(), (int) bookDTO.getQuantity(),
                bookDTO.getBookImage());
        return bookRepository.save(bookStoreData);
    }

    /*
     * This put method is used to update the existing book
     * variable1: id (to search for the book)
     * variable2: BookDTo with updated details
     * @Return : Updated book details
     * */
    @Override
    public BookStoreData updateBookById(int id, BookDTO bookDTO) throws BookNotFoundExecption {
        List<BookStoreData> bookStoreDataList = this.getBookList();
        for(BookStoreData bookStoreData : bookStoreDataList){
            if (bookStoreData.getId() == id){
                bookStoreData.setBookName(bookDTO.getBookName());
                bookStoreData.setAuthorName(bookDTO.getAuthorName());
                bookStoreData.setPrize(bookDTO.getPrize());
                bookStoreData.setQuantity((int) bookDTO.getQuantity());
                bookStoreData.setBookImage(bookDTO.getBookImage());
                return bookRepository.save(bookStoreData);
            }
        }
        return null;
    }

    /*
     * This delete is used to deleting existing book
     * variable: id (to search fo the book)
     * Return: void
     * */
    @Override
    public void deleteBookById(int id) {
        BookStoreData bookStoreData = this.searchBookById(id);
        bookRepository.delete(bookStoreData);
    }

    /*
     * This method is used to search book using its name
     * variable: name
     * @return: Book_store_data
     * */
    @Override
    public BookStoreData searchBookByName(String name)throws BookNotFoundExecption {
        BookStoreData bookStoreData = bookRepository.findByBookName(name);
        if (bookStoreData == null){
            throw  new BookNotFoundExecption("Book not found for the name:" + name);
        }
        return bookStoreData;
    }

    /*
    * @Return: All books in repository in descending order based on prize
    * */
    @Override
    public List<BookStoreData> sortPrizeHighToLow() {
        List<BookStoreData> bookStoreDataList = bookRepository.sortBookByDes();
        return bookStoreDataList;
    }

    /*
     * @Return: All books in repository in ascending order based on prize
     * */
    @Override
    public List<BookStoreData> sortPrizeLowToHigh() {
        List<BookStoreData> bookStoreDataList = bookRepository.sortBookByAsc();
        return bookStoreDataList;
    }

    /*
     * This method is used to search book using its name
     * variable: id
     * @return: Book_store_data with matching name
     * */
    @Override
    public BookStoreData searchBookById(int id){
        return bookRepository.findById(id);
    }
}
