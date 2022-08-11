package com.yogesh.studentsystem.service.impl;

import com.yogesh.studentsystem.entities.Book;
import com.yogesh.studentsystem.entities.Cart;
import com.yogesh.studentsystem.entities.User;
import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.payloads.CartDto;
import com.yogesh.studentsystem.payloads.UserDto;
import com.yogesh.studentsystem.repository.BookRepo;
import com.yogesh.studentsystem.repository.CartRepo;
import com.yogesh.studentsystem.repository.UserRepo;
import com.yogesh.studentsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl  {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserRepo userRepo;

//    @Override
//    public String issueBook(CartDto cartDto) {
//        Optional<User> user = userRepo.findByEmail(cartDto.getUserEmail());
//        if(user==null)
//            return "User not Found";
//
//        Cart cart = cartRepo.findCartByUser(user);
//        List<Book> bookList = new ArrayList<>();
//        if(user!=null && cart==null)
//        {
//            Cart userCart = new Cart();
//            userCart.setCartId(user.get());
//            userCart.setUser(user);
//            Book book = bookRepo.findBookByBookTitle(cartDto.getBookTitle());
//            if(book==null){
//                return "Book not Present in database";
//            }
////            bookList.add(book);
//            book.setCart(userCart);
//            bookList.add(book);
//            book.getCart().setBooks(bookList);
//            userCart.setBooks(bookList);
////            bookRepo.save(book);
//            cartRepo.save(userCart);
//
//
//        }else {
//            List<Book> issuedBooks = cart.getBooks();
//            Book book = bookRepo.findBookByBookTitle(cartDto.getBookTitle());
//            if(book.equals(null)){
//                return "Book not Present in database";
//            }
//            issuedBooks.add(book);
//            book.setCart(cart);
//            bookRepo.save(book);
//            cart.setBooks(issuedBooks);
//            cartRepo.save(cart);
//        }
//
//        return "Book successfully Issued";
//    }
//    @Override
//    public String issueBook(CartDto cartDto) {
//        Optional<User> optionUser=  userRepo.findById(cartDto.getUserId());
//        if(!optionUser.isPresent())
//            return "User not Found";
//        Optional<Cart> optionalCart = cartRepo.findCartByUser(optionUser.get());
//        List<Book> booksList = new ArrayList<>();
//        if(optionUser.isPresent()&&!optionalCart.isPresent()){
//            Cart userCart = new Cart();
//            userCart.setUser(optionUser.get());
//            Optional<Book> addBook = bookRepo.findBookByBookTitle(cartDto.getBookTitle());
//            if(!addBook.isPresent()){
//                return "Book not Present in database";
//            }
//            booksList.add(addBook.get());
//            userCart.setBooks(booksList);
//            cartRepo.save(userCart);
////            Optional<Cart> tempCart= cartRepo.findCartByUser(optionUser.get());
////            addBook.get().setCart(tempCart.get());
//
//        }else{
//            List<Book> issuedBook = optionalCart.get().getBooks();
//            Optional<Book> addBook = bookRepo.findBookByBookTitle(cartDto.getBookTitle());
//            if(!addBook.isPresent()){
//                return "Book not Present in database";
//            }
////            addBook.get().setCart(optionalCart.get());
////            bookRepo.save(addBook.get());
//            issuedBook.add(addBook.get());
//            optionalCart.get().setBooks(issuedBook);
//            cartRepo.save(optionalCart.get());
////            bookRepo.save(addBook.get());
//        }
//        return "Book successfully Issued";
//    }
}
