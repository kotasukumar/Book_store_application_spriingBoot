package com.bridgelabz.BookStore.service;

import com.bridgelabz.BookStore.dto.MyCartDTO;
import com.bridgelabz.BookStore.execption.BookNotFoundExecption;
import com.bridgelabz.BookStore.model.MyCart;
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


    /*
     * Used to add a book into cart
     * data: name (to find book of the name
     * @Return: book details
     * */
    @Override
    public MyCart addToMyCartUsingBookName(String name, MyCartDTO myCartDTO) {
        iBookService.searchBookByName(name);
        MyCart myCart = MyCart.Build(myCartDTO.getId(), myCartDTO.getBookName(), (int) myCartDTO.getQuantity(), myCartDTO.getPrize());
        return cartRepository.save(myCart);
    }

    /*
     * Used to delete book from cart
     * data: name (to search and delete)
     * @Return: void
     * */
    @Override
    public void deleteBookInMyCartUsingBookName(String name)throws BookNotFoundExecption {
        MyCart myCart = cartRepository.findByBookName(name);
        if (myCart ==null){
            throw  new BookNotFoundExecption("Book not found for the name:" + name);
        }
        cartRepository.delete(myCart);
    }

    /*
     * Used to delete book from cart
     * data: name,quantity (to search and delete certain quantity)
     * @Return: void
     * */
    @Override
    public void removeBookInMyCartUsingBookNameAndQuantity(String name, int quantity)throws BookNotFoundExecption {
        MyCart myCart = cartRepository.findByBookName(name);
        if (myCart == null){
            throw  new BookNotFoundExecption("Book not found for the name:" + name);
        }
        myCart.setQuantity(quantity);

    }

    /*
    Used to get list of books that are added to cart
    * @Return: list of book in cart
    * */
    @Override
    public List<MyCart> getMyCartList() {
        return cartRepository.findAll();
    }
}
