package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.CoustomerDetailsDTO;
import com.bridgelabz.BookStore.execption.BookNotFoundExecption;
import com.bridgelabz.BookStore.model.CoustomerData;
import com.bridgelabz.BookStore.repository.CoustmerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Service
public class CoustomerService implements ICoustomerService{

    @Autowired
    CoustmerDetailsRepository coustmerDetailsRepository;

    /*
     * Used to add customer details
     * data : customerDTO
     * @Return : details of customer
     * */
    @Override
    public CoustomerData addCoustomerDetails(CoustomerDetailsDTO coustomerDetailsDTO) {
        CoustomerData coustomerData = CoustomerData.Build(0, coustomerDetailsDTO.getName(),coustomerDetailsDTO.getPhoneNumber(), coustomerDetailsDTO.getPinCode(), coustomerDetailsDTO.getLocality(),
                coustomerDetailsDTO.getAddress(), coustomerDetailsDTO.getCity(), coustomerDetailsDTO.getLandMark());
        return coustmerDetailsRepository.save(coustomerData);
    }

    /*
     * Used to Update customer details
     * data1: name(to search for customer details with this name)
     * data2: customerDto with updated details
     * @Return : Updated customer details
     * */
    @Override
    public CoustomerData editCoustomerDetails(int id, CoustomerDetailsDTO coustomerDetailsDTO) throws BookNotFoundExecption {
        CoustomerData coustomerData1 = coustmerDetailsRepository.findById(id);
        if (coustomerData1 != null) {
            coustomerData1.setName(coustomerDetailsDTO.getName());
            coustomerData1.setPhoneNumber(coustomerDetailsDTO.getPhoneNumber());
            coustomerData1.setPinCode(coustomerDetailsDTO.getPinCode());
            coustomerData1.setLocality(coustomerDetailsDTO.getLocality());
            coustomerData1.setAddress(coustomerDetailsDTO.getAddress());
            coustomerData1.setCity(coustomerDetailsDTO.getCity());
            coustomerData1.setLandMark(coustomerDetailsDTO.getLandMark());
            return coustmerDetailsRepository.save(coustomerData1);
        }else {
            throw  new BookNotFoundExecption("Book not found for the id:" + id);
        }
    }

    /*
     * Used to delete customer details using name
     * data: name (to search customer details  using name)
     * @Return: void
     * */
    @Override
    public void deleteCoustomerDetails(int id) {
        CoustomerData coustomerData = coustmerDetailsRepository.findById(id);
        if (coustomerData == null){
            throw  new BookNotFoundExecption("Book not found for the id:" + id);
        }
        coustmerDetailsRepository.delete(coustomerData);
    }

    /*
     * used to get the list of customer details
     * @Return : customer details
     * */
    @Override
    public List<CoustomerData> getCoustomerDetails() {
        return coustmerDetailsRepository.findAll();
    }
}
