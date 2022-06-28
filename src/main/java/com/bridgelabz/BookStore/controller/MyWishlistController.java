package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.dto.MyWishlistDTO;
import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.model.MyCart;
import com.bridgelabz.BookStore.service.IWishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/bookstoreapp/mywishlist")
public class MyWishlistController {
    @Autowired
    private IWishlistService iWishlistService;

    /*
    Used to get list of books that are added to wish list
    * @Return: list of book in wish list with message
    * */
    @GetMapping("/getmywishlist")
    public ResponseEntity<ReasponseDTO> getMyWhishlist(){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Books in your wishlist are ", iWishlistService.getMyWhishlist());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
     * Used to add a book into wish list
     * @Path: name (to find book of the name)
     * @Return: book details with added message
     * */
    @PostMapping("/addbook/{name}")
    public ResponseEntity<ReasponseDTO> addBookToMyWishlist(@PathVariable("name") String name, @RequestBody @Valid MyWishlistDTO myWishlistDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Book added to my wishlist", iWishlistService.addBookToMyWhishlistUsingName(name, myWishlistDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
     * Used to delete book from wish list
     * @Path: name (to search and delete)
     * @Return: deleted message wth name of the book
     * */
    @DeleteMapping("/delete/{name}")
    public ResponseEntity<ReasponseDTO> deleteBookFromMyWishlist(@PathVariable("name")String name){
        iWishlistService.deleteBookFromMyWishlist(name);
        ReasponseDTO reasponseDTO = new ReasponseDTO("deleted book from my wishlist", "Deleted book is: " + name);
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
     * Used to add a book into cart
     * @Path: name (to find book of the name)
     * @Return: book details with added message
     * */
    @PostMapping("/addtomycart/{name}")
    public ResponseEntity<ReasponseDTO> addBookToMyCart(@PathVariable("name")String name, @RequestBody @Valid MyCartDTO myCartDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Added to mycart", iWishlistService.addToMyCartUsingBookName(name, myCartDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
