package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.execption.BookNotFoundExecption;
import com.bridgelabz.BookStore.model.BookStoreData;
import com.bridgelabz.BookStore.model.MyCart;
import com.bridgelabz.BookStore.model.Registration;
import com.bridgelabz.BookStore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyCartService implements ICartService{

    @Autowired
    private IBookService iBookService;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    IRegistrationService iRegistrationService;


    /*
     * Used to add a book into cart
     * data: name (to find book of the name
     * @Return: book details
     * */
    @Override
    public MyCart addToMyCartUsingId(int id, int userID) {
        Registration registration = iRegistrationService.getUserById(id);
        BookStoreData bookStoreData = iBookService.searchBookById(id);
        if(bookStoreData.getQuantity() > 0) {
            MyCart myCart = MyCart.Build(0, bookStoreData.getBookName(), 1, bookStoreData.getPrize(), bookStoreData.getBookImage(),
                    bookStoreData.getAuthorName(), userID);
            return cartRepository.save(myCart);
        }else if(bookStoreData.getQuantity() == 0){
            return null;
        }else {
            return null;
        }
    }

    /*
     * Used to delete book from cart
     * data: name (to search and delete)
     * @Return: void
     * */
    @Override
    public void deleteBookInMyCartUsingId(int id)throws BookNotFoundExecption {
        MyCart myCart = cartRepository.findById(id);
        if (myCart ==null){
            throw  new BookNotFoundExecption("Book not found for the name:" + id);
        }
        cartRepository.delete(myCart);
    }

    /*
    Used to get list of books that are added to cart
    * @Return: list of book in cart
    * */
    @Override
    public List<MyCart> getMyCartList() {
        return cartRepository.findAll();
    }

    @Override
    public MyCart increaseBookQuantityByOne(int id) {
        BookStoreData bookStoreData = iBookService.searchBookById(id);
        MyCart myCart = cartRepository.findById(id);
        if (myCart != null && bookStoreData.getQuantity() >= myCart.getQuantity()) {
            myCart.setQuantity(myCart.getQuantity() + 1);
            myCart.setPrize(myCart.getPrize() + bookStoreData.getPrize());
            return cartRepository.save(myCart);
        }else {
            return null;
        }
    }

    @Override
    public MyCart decreaseBookQuantityByOne(int id) {
        BookStoreData bookStoreData = iBookService.searchBookById(id);
        MyCart myCart = cartRepository.findById(id);
        if (myCart != null && myCart.getQuantity() >= 0) {
            myCart.setQuantity(myCart.getQuantity() - 1);
            myCart.setPrize(myCart.getPrize() - bookStoreData.getPrize());
            return cartRepository.save(myCart);
        }else {
            return null;
        }
    }

    @Override
    public List<MyCart> getCartByUserId(int id) {
        return cartRepository.findByCartId(id);
    }


}
