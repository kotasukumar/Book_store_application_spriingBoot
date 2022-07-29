package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.dto.MyWishlistDTO;
import com.bridgelabz.BookStore.execption.BookNotFoundExecption;
import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.model.MyCart;
import com.bridgelabz.BookStore.model.MyWishList;
import com.bridgelabz.BookStore.repository.BookRepository;
import com.bridgelabz.BookStore.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyWhishlistService implements IWishlistService{

    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICartService iCartService;

    @Autowired
    WishlistRepository wishlistRepository;

    //List<BookStoreData> myWhishlist = new ArrayList<>();

    /*
    Used to get list of books that are added to wish list
    * @Return: list of book in wish list
    * */
    @Override
    public List<MyWishList> getMyWhishlist() {
        return wishlistRepository.findAll();
    }

    /*
     * Used to add a book into wish list
     * data: name (to find book of the name)
     * @Return: book details
     * */
    @Override
    public MyWishList addBookToMyWhishlistUsingName(String name, MyWishlistDTO myWishlistDTO)throws BookNotFoundExecption {
        BookStoreData bookStoreData = iBookService.searchBookByName(name);
        if (bookStoreData != null) {
            MyWishList myWishList = MyWishList.Build(myWishlistDTO.getId(), myWishlistDTO.getBookName(), (int) myWishlistDTO.getQuantity(), myWishlistDTO.getPrize());
            return wishlistRepository.save(myWishList);
        }else {
            throw  new BookNotFoundExecption("Book not found for the name:" + name);
        }
    }

    /*
     * Used to delete book from wish list
     * data: name (to search and delete)
     * @Return: void
     * */
    @Override
    public void deleteBookFromMyWishlist(String name)throws BookNotFoundExecption {
        MyWishList myWishList = wishlistRepository.findByBookName(name);
        if (myWishList == null){
            throw  new BookNotFoundExecption("Book not found for the name:" + name);
        }
        wishlistRepository.delete(myWishList);
    }

}
