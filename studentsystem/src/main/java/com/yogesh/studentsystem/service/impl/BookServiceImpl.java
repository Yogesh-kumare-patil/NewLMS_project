package com.yogesh.studentsystem.service.impl;

import com.yogesh.studentsystem.entities.Book;
import com.yogesh.studentsystem.exceptions.ResourceNotFoundException;
import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.repository.BookRepo;
import com.yogesh.studentsystem.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = this.modelMapper.map(bookDto, Book.class);
        Book addedBook = this.bookRepo.save(book);
        return this.modelMapper.map(addedBook,BookDto.class);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Integer bookId) {
        Book book = this.bookRepo.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException("Book","Book Id",bookId));
        book.setBookTitle(bookDto.getBookTitle());
        book.setAuthor(bookDto.getAuthor());

        Book updatedBook = this.bookRepo.save(book);

        return this.modelMapper.map(updatedBook,BookDto.class);
    }

    @Override
    public void deleteBook(Integer bookId) {
        Book book = this.bookRepo.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException("Book","Book Id",bookId));

        this.bookRepo.delete(book);
    }

    @Override
    public BookDto getBookById(Integer bookId) {

        Book book = this.bookRepo.findById(bookId)
                .orElseThrow(()->new ResourceNotFoundException("Book","Book Id",bookId));


        return this.modelMapper.map(book,BookDto.class);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> books = this.bookRepo.findAll();
        List<BookDto> bookDtos = books.stream().map((book) -> this.modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtos;
    }

    @Override
    public List<BookDto> getAllIssuedBooks() {
        List<Book> books = this.bookRepo.findAll();
        List<Book> issuedBooks = new ArrayList<>();
        for(int i=0;i<books.size();i++){
            if(books.get(i).getCart()!=null){
                issuedBooks.add(books.get(i));
            }
        }
        List<BookDto> bookDtos = issuedBooks.stream().map((book) -> this.modelMapper.map(book,BookDto.class)).collect(Collectors.toList());
        return bookDtos;
    }
}
