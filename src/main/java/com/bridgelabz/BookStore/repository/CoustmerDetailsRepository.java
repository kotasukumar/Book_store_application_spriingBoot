package com.bridgelabz.BookStore.repository;

import com.bridgelabz.BookStore.model.CoustomerData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoustmerDetailsRepository extends JpaRepository<CoustomerData, String> {

    CoustomerData findById(int id);
}
