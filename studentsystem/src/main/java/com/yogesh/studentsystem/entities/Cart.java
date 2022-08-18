package com.yogesh.studentsystem.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Book_Cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

//    @JsonBackReference
//    private List<Book> bookList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cartId;

//    private Date issuedDate;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

//    @OneToOne(fetch = FetchType.LAZY,optional = false)
//    @JoinColumn(name = "user_id")
//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;



}
