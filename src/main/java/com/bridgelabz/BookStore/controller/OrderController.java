package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.ResponseCartDTO;
import com.bridgelabz.BookStore.service.ICartService;
import com.bridgelabz.BookStore.service.ICoustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstoreapp/order")
public class OrderController {

    @Autowired
    private ICartService iCartService;
    @Autowired
    private ICoustomerService iCoustomerService;

    /*Used to get summary of the order
    * @Return: message, list of book, delivery address
    * */
    @GetMapping("/summery")
    public ResponseEntity<ResponseCartDTO> getOrderSummary(){
        ResponseCartDTO responseCartDTO = new ResponseCartDTO("Order placed successfully", iCartService.getMyCartList(), iCoustomerService.getCoustomerDetails());
        return new ResponseEntity<>(responseCartDTO, HttpStatus.OK);
    }
}
