package com.harbor.samples.bookInfo.models;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;

import lombok.Getter;
import lombok.Setter;

@Table(name = "book")
@Entity(name = "book")
@Getter
@Setter
public class Book implements Serializable {
    @Autowired
    @Transient
    private ModelMapper modelMapper;

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String author;

    @Nullable
    private String isbn;
    @Nullable
    private String publisher;

    private long createdAt;

    @Nullable
    private String creditCardNumber;

    @OneToMany(mappedBy = "forBook")
    private Set<Review> reviews;

    public BookDTO convertToDto() {
        BookDTO bookDTO = modelMapper.map(this, BookDTO.class);
        return bookDTO;
    }
}
