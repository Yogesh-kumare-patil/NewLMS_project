package com.yogesh.studentsystem.service;

import com.yogesh.studentsystem.controller.dto.BookDto;
import com.yogesh.studentsystem.model.Book;
import com.yogesh.studentsystem.repository.BookRepo;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepo bookRepo;

    public BookService(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Book addBookService(BookDto bookDto){
        Book newBook= new Book();
        newBook.setName(bookDto.getName());
        newBook.setAuthor(bookDto.getAuthor());
        newBook.setCategery(bookDto.getCategery());
        return bookRepo.save(newBook);
    }
}
