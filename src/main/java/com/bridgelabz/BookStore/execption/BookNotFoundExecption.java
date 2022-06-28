package com.bridgelabz.BookStore.execption;

public class BookNotFoundExecption extends RuntimeException{
    public BookNotFoundExecption(String message){
        super(message);
    }
}
