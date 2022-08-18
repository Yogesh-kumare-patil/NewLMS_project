package com.yogesh.studentsystem.repository;

import com.yogesh.studentsystem.entities.Cart;
import com.yogesh.studentsystem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepo extends JpaRepository<Cart,Integer> {
//    Cart findCartByUser(User user);
//    Cart findByBookTitle(String title);
//    Cart findBookById(Integer bookId);

}
