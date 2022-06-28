package com.bridgelabz.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class CoustomerData {
    @Id
    private int orderId;
    private String name;
    private String phoneNumber;
    private long pinCode;
    private String locality;
    private String address;
    private String city;
    private String landMark;
    private String email;
}
