package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstoreapp/mycart")
public class MyCartController {

    /*
    * ICartService to inject its dependency in this class*/
    @Autowired
    private ICartService iCartService;

    /*
    Used to get list of books that are added to cart
    * @Return: list of book in cart with message
    * */
    @GetMapping("/getcartlist")
    public ResponseEntity<ReasponseDTO> getMyCartList(){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Books in cart are", iCartService.getMyCartList());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * Used to add a book into cart
    * @Path: name (to find book of the name
    * @Return: book details with added message
    * */
    @PostMapping("/addbook/{bookName}")
    public ResponseEntity<ReasponseDTO> addBookToMyCart(@PathVariable("bookName") String bookName, @RequestBody @Valid MyCartDTO myCartDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("book added successfully", iCartService.addToMyCartUsingBookName(bookName, myCartDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * Used to delete book from cart
    * @Path: name,quantity (to search and delete certain quantity)
    * @Return: deleted message wth name of the book and quantity
    * */
    @DeleteMapping("/deletequantity/{bookName}/{quanity}")
    public ResponseEntity<ReasponseDTO> deleteQuantity(@PathVariable("bookName") String bookName, @PathVariable("quantity") int quantity){
        iCartService.removeBookInMyCartUsingBookNameAndQuantity(bookName, quantity);
        ReasponseDTO reasponseDTO = new ReasponseDTO("deleted successfully", "deleted book name and quantity: " + bookName  + " " + quantity);
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
     * Used to delete book from cart
     * @Path: name (to search and delete)
     * @Return: deleted message wth name of the book
     * */
    @DeleteMapping("/delete/{bookName}")
    public ResponseEntity<ReasponseDTO> deletebook(@PathVariable String bookName){
        iCartService.deleteBookInMyCartUsingBookName(bookName);
        ReasponseDTO reasponseDTO = new ReasponseDTO("deleted successfully", "Deleted book name: " + bookName);
        return  new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
