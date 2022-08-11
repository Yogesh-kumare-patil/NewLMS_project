package com.yogesh.studentsystem.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "Books")
@NoArgsConstructor
@Getter
@Setter
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Column(name = "BookTitle",length = 100, nullable = false)
    private String bookTitle;

    @Column(name = "Author")
    private String author;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

}
