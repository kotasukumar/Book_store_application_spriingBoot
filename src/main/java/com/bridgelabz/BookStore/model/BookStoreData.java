package com.bridgelabz.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class BookStoreData {
    @Id
    @GeneratedValue
    private int id;
    private String bookName;
    private String authorName;
    private float prize;
    private int quantity;
}
