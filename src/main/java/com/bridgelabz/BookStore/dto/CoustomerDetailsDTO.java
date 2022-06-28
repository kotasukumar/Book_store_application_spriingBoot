package com.bridgelabz.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CoustomerDetailsDTO {

    @NotNull(message = "id should not null")
    public int orderId;

    @NotNull(message = "Name should not null")
    public String name;

    @NotNull(message = "Phone number should not null")
    public String phoneNumber;

    @NotNull(message = "pin code should not null")
    public long pinCode;

    @NotNull(message = "Locality name should not null")
    public String locality;

    @NotNull(message = "Address should not null")
    public String address;

    @NotNull(message = "City name should not null")
    public String city;

    @NotNull(message = "Land mark should not null")
    public String landMark;

    @NotNull(message = "Email should not null")
    public String email;
}
