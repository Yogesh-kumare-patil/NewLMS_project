package com.yogesh.studentsystem.service.impl;

import com.yogesh.studentsystem.entities.Book;
import com.yogesh.studentsystem.entities.Cart;
import com.yogesh.studentsystem.entities.User;
import com.yogesh.studentsystem.exceptions.BookIsAlreadyIssuedException;
import com.yogesh.studentsystem.exceptions.ResourceNotFoundException;
import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.payloads.CartDto;
import com.yogesh.studentsystem.payloads.UserDto;
import com.yogesh.studentsystem.repository.BookRepo;
import com.yogesh.studentsystem.repository.CartRepo;
import com.yogesh.studentsystem.repository.UserRepo;
import com.yogesh.studentsystem.service.CartService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService  {
    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public String issueBook(CartDto cartDto) {
          Book book = bookRepo.findByBookId(cartDto.getBookId());
        Optional<User> user = userRepo.findByEmail(cartDto.getUserEmail());
        if(book == null){
            // book is not present
            throw new ResourceNotFoundException("Book","Id",cartDto.getBookId());
        }
//        Cart cart = cartRepo.findBookById(cartDto.getBookId());
        Cart cart = book.getCart();
        if(cart != null){
            // book is already issued
            throw new BookIsAlreadyIssuedException("Book","Id",cartDto.getBookId());
        }
        Cart userCart = new Cart();
        userCart.setCartId(user.get().getId());
        userCart.setUser(user.get());

        book.setCart(userCart);

        cartRepo.save(userCart);
        bookRepo.save(book);
        return "Book successfully Issued";

    }

    @Override
    public String returnBook(CartDto cartDto) {
        Book book = bookRepo.findByBookId(cartDto.getBookId());
        Optional<User> user = userRepo.findByEmail(cartDto.getUserEmail());
        if(book == null || book.getCart() == null){
            // book is not present
            throw new ResourceNotFoundException("Book","Id",cartDto.getBookId());
        }
        if(book.getCart().getUser() == user.get()){
            book.setCart(null);
            bookRepo.save(book);
            return "Book is returned Successfully";
        }
        return "This user has no books to return";
    }

    @Override
    public List<BookDto> getAllIssuedBooksByUserId(Integer userId) {
        List<Book> books = this.bookRepo.findAll();
        List<Book> issuedBooks = new ArrayList<>();

        for(int i=0;i<books.size();i++){
            if(books.get(i).getCart()!=null){
                if(books.get(i).getCart().getUser().getId()==userId){
                    issuedBooks.add(books.get(i));
                }
            }
        }
        List<BookDto> bookDtos = issuedBooks.stream().map((book) -> this.modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtos;
    }

}
