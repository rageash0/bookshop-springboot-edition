package com.rageash.bookshopspringbootedition.book;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Book {
    
    @Id
    @SequenceGenerator(
        name = "book_sequence",
        sequenceName = "book_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "book_sequence"
    )
    private long id;
    private long isbn;
    private String title;
    private String author;
    @Column(columnDefinition = "TEXT")
    private String description;
    private String edition;
    private String publisher;
    private int page;
    private BigDecimal price;
    private String category;
    private String language;

    public Book(long isbn, 
                String title, 
                String author, 
                String description, 
                String edition, 
                String publisher, 
                int page, 
                BigDecimal price, 
                String category, 
                String language){

        setIsbn(isbn);
        setTitle(title);
        setAuthor(author);
        setDescription(description);
        setEdition(edition);
        setPublisher(publisher);
        setPage(page);
        setPrice(price);
        setCategory(category);
        setLanguage(language);
    }
}
