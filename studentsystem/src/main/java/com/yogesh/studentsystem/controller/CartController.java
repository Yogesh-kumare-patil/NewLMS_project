package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.payloads.CartDto;
import com.yogesh.studentsystem.payloads.UserDto;
import com.yogesh.studentsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/issueBook")
    public ResponseEntity<String> issueBook(@RequestBody CartDto cartDto){
        String issueBook = this.cartService.issueBook(cartDto);
        return new ResponseEntity<String>(issueBook, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/returnBook")
    public ResponseEntity<String> returnBook(@RequestBody CartDto cartDto){
        String returnBook = this.cartService.returnBook(cartDto);
        return new ResponseEntity<String>(returnBook, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<BookDto>> getALlIssuedBookByUser(@PathVariable Integer userId){
//        List<BookDto> books = this.cartService.getAllIssuedBooksByUser();
        return ResponseEntity.ok(this.cartService.getAllIssuedBooksByUserId(userId));
    }

//    @GetMapping("/{userId}")
//    public ResponseEntity<UserDto> getSingleUsers(@PathVariable Integer userId){
//        return ResponseEntity.ok(this.userService.getUserById(userId));
//    }
}
