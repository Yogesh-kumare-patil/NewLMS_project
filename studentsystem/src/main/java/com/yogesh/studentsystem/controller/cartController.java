package com.yogesh.studentsystem.controller;

import com.yogesh.studentsystem.controller.dto.IssueBookReq;
import com.yogesh.studentsystem.model.Book;
import com.yogesh.studentsystem.service.BookService;
import com.yogesh.studentsystem.service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cart")
public class cartController {

    CartService cartService;

    public cartController(CartService cartService) {
        super();
        this.cartService = cartService;
    }

    @PostMapping("/addBook")
    public String issueBookController(@RequestBody IssueBookReq issueBookReq){
        return cartService.issueBookService(issueBookReq);
    }

}
