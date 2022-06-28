package com.bridgelabz.BookStore.dto;

import com.bridgelabz.BookStore.model.BookStoreData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyWishlistDTO {
    //List<BookStoreData> myWhishlist;

    @NotNull(message = "id should not null")
    public int id;

    @NotNull(message = "Book name should not null")
    public String bookName;

    @NotNull(message = "Prize should not null")
    public float prize;

    @NotNull(message = "Quantity should not null")
    public float quantity;
}
