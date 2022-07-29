package com.bridgelabz.BookStore.controller;

import com.bridgelabz.BookStore.dto.CoustomerDetailsDTO;
import com.bridgelabz.BookStore.dto.ReasponseDTO;
import com.bridgelabz.BookStore.model.CoustomerData;
import com.bridgelabz.BookStore.service.ICoustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/bookstoreapp/deliverydetails")
public class CoustomerDetailsController {

    /*
    * ICoustomerService to inject its dependency in this class
    * */
    @Autowired
    private ICoustomerService iCoustomerService;

    /*
    * Used to add customer details
    * @body: customerDTO
    * @Return : details of customer with added message
    * */
    @PostMapping("/adddetails")
    public ResponseEntity<ReasponseDTO> addDeliveryDetails(@RequestBody @Valid CoustomerDetailsDTO coustomerData){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Delivery details added successfully", iCoustomerService.addCoustomerDetails(coustomerData));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * Used to Update customer details
    * @Path: name(to search for customer details with this name)
    * @Body: customerDto with updated details
    * @Return : Updated customer details with updated message
    * */
    @PutMapping("/updatedetails/{id}")
    public ResponseEntity<ReasponseDTO> updateDeliveryDetails(@PathVariable("id") int id, @RequestBody @Valid CoustomerDetailsDTO coustomerDetailsDTO){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Delivery details updated", iCoustomerService.editCoustomerDetails(id, coustomerDetailsDTO));
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * Used to delete customer details using name
    * @path: name (to search customer details  using name)
    * @Return: deleted message with message
    * */
    @DeleteMapping("/deletedetails/{id}")
    public ResponseEntity<ReasponseDTO> deleteDeliveryDetails(@PathVariable("id")int id){
        iCoustomerService.deleteCoustomerDetails(id);
        ReasponseDTO reasponseDTO = new ReasponseDTO("Deleted successfully", "Please enter delivery details for placing order");
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }

    /*
    * used to get the list of customer details
    * @Return : customer details with message
    * */
    @GetMapping("/getdetails")
    public ResponseEntity<ReasponseDTO> getDeliveryDetails(){
        ReasponseDTO reasponseDTO = new ReasponseDTO("Customer details are", iCoustomerService.getCoustomerDetails());
        return new ResponseEntity<>(reasponseDTO, HttpStatus.OK);
    }
}
