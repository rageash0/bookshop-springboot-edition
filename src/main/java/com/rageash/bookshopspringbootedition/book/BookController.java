package com.rageash.bookshopspringbootedition.book;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/book")
public class BookController {
    
    private BookService bookService;

    @Autowired
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getBooks(){
        return bookService.getBooks();
    }

    @PostMapping
    public void addNewBook(@RequestBody Book book){
        bookService.addNewBook(book);
    }

    @DeleteMapping(path = "{bookId}")
    public void deleteBook(@PathVariable("bookId") long id){
        bookService.deleteBook(id);
    }

    @PutMapping(path = "{bookId}")
    public void updateBook(@PathVariable("bookId") Long id,
                            @RequestParam(required = false) Long isbn,
                            @RequestParam(required = false) String title,
                            @RequestParam(required = false) String author,
                            @RequestParam(required = false) String description,
                            @RequestParam(required = false) String edition,
                            @RequestParam(required = false) String publisher,
                            @RequestParam(required = false) Integer page,
                            @RequestParam(required = false) BigDecimal price,
                            @RequestParam(required = false) String category,
                            @RequestParam(required = false) String language){
        
        bookService.updateBook(
                                id,
                                isbn,
                                title,
                                author,
                                description,
                                edition,
                                publisher,
                                page,
                                price,
                                category,
                                language
                            ); 
    }
}
