package com.bridgelabz.BookStore.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
    @NotNull(message = "Book name should not null")
    public String bookName;

    @NotNull(message = "Author name should not null")
    public String authorName;

    @NotNull(message = "Prize should not null")
    public float prize;

    @NotNull(message = "Quantity should not null")
    public float quantity;
}
