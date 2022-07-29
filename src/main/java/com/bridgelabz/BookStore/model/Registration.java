package com.bridgelabz.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor(staticName = "Built")
@NoArgsConstructor
@Entity
@Table(name = "UserRegistration")
public class Registration {
    /*Creating registration table in database with the required columns*/
    @Id  //Declaring primary key
    @GeneratedValue  // Generating id value with autoincrement
    private int id;
    private String userName;
    private String emailID;
    private String password;
}