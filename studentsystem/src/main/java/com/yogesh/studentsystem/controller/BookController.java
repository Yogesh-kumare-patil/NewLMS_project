package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.payloads.ApiResponse;
import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    //create
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/")
    public ResponseEntity<BookDto> createBook(@Valid @RequestBody BookDto bookDto){
        BookDto createBook = this.bookService.createBook(bookDto);
        return new ResponseEntity<BookDto>(createBook, HttpStatus.CREATED);
    }

    //update
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{bookId}")
    public ResponseEntity<BookDto> updateBook(@Valid @RequestBody BookDto bookDto,@PathVariable Integer bookId){
        BookDto updatedBook = this.bookService.updateBook(bookDto,bookId);
        return new ResponseEntity<BookDto>(updatedBook, HttpStatus.OK);
    }

    //delete
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{bookId}")
    public ResponseEntity<ApiResponse> deleteBook(@PathVariable Integer bookId){
        this.bookService.deleteBook(bookId);
        return new ResponseEntity<ApiResponse>(new ApiResponse("Book is deleted Successfully !!",true), HttpStatus.OK);
    }


    //get
    @GetMapping("/{bookId}")
    public ResponseEntity<BookDto> getBook(@PathVariable Integer bookId){
            BookDto bookDto = this.bookService.getBookById(bookId);
            return new ResponseEntity<BookDto>(bookDto,HttpStatus.OK);
    }

    //get all
    @GetMapping("/")
    public ResponseEntity<List<BookDto>> getALlBook(){
        List<BookDto> books = this.bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/issuedBook")
    public ResponseEntity<List<BookDto>> getALlIssuedBook(){
        List<BookDto> books = this.bookService.getAllIssuedBooks();
        return ResponseEntity.ok(books);
    }
}
