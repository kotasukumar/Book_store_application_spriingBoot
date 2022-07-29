package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ResponseCartDTO;
import com.bridgelabz.BookStore.service.ICartService;
import com.bridgelabz.BookStore.service.ICoustomerService;
import com.bridgelabz.BookStore.service.IRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/bookstoreapp/order")
public class OrderController {

    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICoustomerService iCoustomerService;

    /*Used to get summary of the order
    * @Return: message, list of book, delivery address
    * */
    @GetMapping("/summery/{id}")
    public ResponseEntity<ResponseCartDTO> getOrderSummary(@PathVariable int id){
        ResponseCartDTO responseCartDTO = new ResponseCartDTO("Order placed successfully", iCartService.getCartByUserId(id), iCoustomerService.getCoustomerDetails());
        return new ResponseEntity<>(responseCartDTO, HttpStatus.OK);
    }
}
