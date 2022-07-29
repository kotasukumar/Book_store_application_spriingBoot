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
@CrossOrigin(allowedHeaders = "*", origins = "*")
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
    @PostMapping("/addbook/{id}/{userID}")
    public ResponseEntity<ReasponseDTO> addBookToMyCart(@PathVariable int id,@PathVariable int userID){
        ReasponseDTO reasponseDTO = new ReasponseDTO("book added successfully", iCartService.addToMyCartUsingId(id, userID));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }


    /*
     * Used to delete book from cart
     * @Path: name (to search and delete)
     * @Return: deleted message wth name of the book
     * */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReasponseDTO> deletebook(@PathVariable int id){
        iCartService.deleteBookInMyCartUsingId(id);
        ReasponseDTO reasponseDTO = new ReasponseDTO("deleted successfully", "Deleted book id: " + id);
        return  new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @PutMapping("/increaseByOne/{id}")
    public ResponseEntity<ReasponseDTO> increaseBookQuantity(@PathVariable int id){
        ReasponseDTO reasponseDTO =  new ReasponseDTO("Increasing book quantity", iCartService.increaseBookQuantityByOne(id));
        return  new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @PutMapping("/decreaseByOne/{id}")
    public ResponseEntity<ReasponseDTO> decreaseBookQuantity(@PathVariable int id){
        ReasponseDTO reasponseDTO =  new ReasponseDTO("Increasing book quantity", iCartService.decreaseBookQuantityByOne(id));
        return  new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    @GetMapping("/getCartByUserId/{id}")
    public ResponseEntity<ReasponseDTO> getCartByUserId(@PathVariable int id){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Books in this user is", iCartService.getCartByUserId(id));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
