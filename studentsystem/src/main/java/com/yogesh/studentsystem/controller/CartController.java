package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.payloads.BookDto;
import com.yogesh.studentsystem.payloads.CartDto;
import com.yogesh.studentsystem.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("api/cart")
public class CartController {

//    @Autowired
//    private CartService cartService;
//
//    @PostMapping("/issueBook")
//    public ResponseEntity<String> issueBook(@RequestBody CartDto cartDto){
//        String issueBook = this.cartService.issueBook(cartDto);
//        return new ResponseEntity<String>(issueBook, HttpStatus.OK);
//    }
}
