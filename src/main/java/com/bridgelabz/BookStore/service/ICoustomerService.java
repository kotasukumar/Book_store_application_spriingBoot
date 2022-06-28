package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.CoustomerDetailsDTO;
import com.bridgelabz.BookStore.model.CoustomerData;

import java.util.List;

public interface ICoustomerService {

    CoustomerData addCoustomerDetails(CoustomerDetailsDTO coustomerDetailsDTO);

    CoustomerData editCoustomerDetails(String name, CoustomerDetailsDTO coustomerDetailsDTO);

    void deleteCoustomerDetails(String name);

    List<CoustomerData> getCoustomerDetails();
}
