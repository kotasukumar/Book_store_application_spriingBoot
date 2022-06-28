package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.BookDTO;
import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstoreapp")
public class BookStoreController {

    /*
    * To do dependency injection
    * */
    @Autowired
    private IBookService iBookService;

    /*
    *Any request like "/bookstore", "/bookstore/", "/bookstore" can access this request method
    *This will return all the books that are stored in repository
    *@Return: list of books with message
    * */
    @RequestMapping(value = {"", "/", "/home"})
    public ResponseEntity<ReasponseDTO> getBookStoreData(){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Books available are", iBookService.getBookList());
        return new ResponseEntity<ReasponseDTO>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * This method is used to search book using its name
    * @Path: name
    * @return: Book_store_data with message to respond
    * */
    @GetMapping("/get/{name}")
    public ResponseEntity getBookList(@PathVariable("name") String name){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Results for your search", iBookService.searchBookByName(name));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * This post is used to add a book into the repository
    * @Body: BookDTO
    * @Return: details of book that we added with message
    * */
    @PostMapping("/create")
    public ResponseEntity createBook(@RequestBody BookDTO bookDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Created successfully", iBookService.createBook(bookDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * This put method is used to update the existing book
    * @Path: id (to search for the book)
    * @Body: BookDTo with updated details
    * @Return : Updated book details with message
    * */
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable("id") int id, @RequestBody @Valid BookDTO bookDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Updated successfully", iBookService.updateBookById(id, bookDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * This delete is used to deleting existing book
    * @Path: id (to search fo the book)
    * Return: ResponseDTO with message
    * */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable("id")int id){
        iBookService.deleteBookById(id);
        ReasponseDTO reasponseDTO = new ReasponseDTO("Deleted successfully", "Deleted Book id is: " + id);
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
