package com.yogesh.studentsystem.service;

import com.yogesh.studentsystem.payloads.BookDto;

import java.util.List;

public interface BookService {

    //create
    BookDto createBook(BookDto bookDto);


    //update
    BookDto updateBook(BookDto bookDto,Integer bookId);


    //delete
    void deleteBook(Integer bookId);


    //get
    BookDto getBookById(Integer bookId);

    //get All
    List<BookDto> getAllBooks();


}
