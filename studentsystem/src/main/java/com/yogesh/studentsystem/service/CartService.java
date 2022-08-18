package com.yogesh.studentsystem.service;

import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.payloads.CartDto;

import java.util.List;

public interface CartService {

    String issueBook(CartDto cartDto);

    String returnBook(CartDto cartDto);

    List<BookDto> getAllIssuedBooksByUserId(Integer userId);
}
