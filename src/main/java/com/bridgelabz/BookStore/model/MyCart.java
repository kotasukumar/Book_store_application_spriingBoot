package com.bridgelabz.BookStore.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Data
@Entity
@AllArgsConstructor(staticName = "Build")
@NoArgsConstructor
public class MyCart {
    //private List<BookStoreData> bookStoreDataList;

    @Id
    private int id;
    private String bookName;
    private int quantity;
    private float prize;
}
