package com.yogesh.studentsystem.repository;


import com.yogesh.studentsystem.entities.Book;
import com.yogesh.studentsystem.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Integer> {
//    Book findBookByBookTitle(String title);
    Book findByBookId(Integer BookId);
//
//    List<Book> getAllByCart();
//    @Query("select b from Book b where b.cart = null")
//    List<Book> findAllIssuedBook();
}
