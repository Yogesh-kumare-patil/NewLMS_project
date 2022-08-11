package com.yogesh.studentsystem.repository;


import com.yogesh.studentsystem.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepo extends JpaRepository<Book,Integer> {
    Book findBookByBookTitle(String title);
}
