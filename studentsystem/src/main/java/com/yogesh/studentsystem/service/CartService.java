package com.yogesh.studentsystem.service;

import com.yogesh.studentsystem.controller.dto.IssueBookReq;
import com.yogesh.studentsystem.model.Book;
import com.yogesh.studentsystem.model.User;
import com.yogesh.studentsystem.repository.BookRepo;
import com.yogesh.studentsystem.repository.CartRepo;
import com.yogesh.studentsystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CartService {

    private UserRepository userRepository;
    private BookRepo bookRepo;
    private CartRepo cartRepo;

    public CartService(UserRepository userRepository, BookRepo bookRepo,CartRepo cartRepo ) {
        super();
        this.userRepository = userRepository;
        this.bookRepo=bookRepo;
        this.cartRepo=cartRepo;
    }

    public String issueBookService(IssueBookReq issueBookReq){
        List<Book> issuedBook = bookRepo.findByName(issueBookReq.getName());
        System.out.println(issueBookReq.getUsername());
        User user = userRepository.findByEmail(issueBookReq.getUsername());
        System.out.println(user.getFirstName());
        user.getCart().setBooks(issuedBook);
        return "Book issued Successfully";
    }

}
