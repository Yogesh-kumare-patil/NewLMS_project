package com.yogesh.studentsystem.payloads;

import com.yogesh.studentsystem.entities.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
@Setter
public class BookDto {

    private Integer bookId;

    @NotBlank
    @Size(min = 3,message = "Min size of Book title is 3")
    private String bookTitle;

    @NotBlank
    @Size(min = 3,message = "min size of author name is 3")
    private String author;


}
