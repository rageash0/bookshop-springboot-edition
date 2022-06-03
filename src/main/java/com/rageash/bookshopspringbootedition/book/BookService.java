package com.rageash.bookshopspringbootedition.book;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public void addNewBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(long id) {
        boolean exists = bookRepository.existsById(id);

        if(!exists)
            throw new IllegalStateException("Book with id : " +id+ " not exists");

        bookRepository.deleteById(id);
    }

    @Transactional
    public void updateBook(long id, 
                            Long isbn, 
                            String title, 
                            String author, 
                            String description, 
                            String edition,
                            String publisher, 
                            Integer page, 
                            BigDecimal price, 
                            String category, 
                            String language) {

        Book book = bookRepository.findById(id)
                                    .orElseThrow(() -> new IllegalStateException(
                                        "Book with id : " +id+ " not exists"
                                    ));

        if(isbn != null && 
                isbn > 999999999999L && 
                    isbn != book.getIsbn())

            book.setIsbn(isbn);

        if(title != null &&
                title.length() > 0 &&
                    !Objects.equals(title, book.getTitle()))

            book.setTitle(title);

        if(author != null &&
                author.length() > 0 &&
                    !Objects.equals(author, book.getAuthor()))
            
            book.setAuthor(author);

        if(description != null &&
                description.length() > 0 &&
                    !Objects.equals(description, book.getDescription()))
                
            book.setDescription(description);

        if(edition != null &&
                edition.length() > 0 &&
                    !Objects.equals(edition, book.getEdition()))

            book.setEdition(edition);

        if(publisher != null &&
                publisher.length() > 0 &&
                    !Objects.equals(publisher, book.getPublisher()))

            book.setPublisher(publisher);

        if(page != null &&
                page > 0 && 
                    page != book.getPage())

            book.setPage(page);

        if(price != null && 
                price.doubleValue() > 0 &&
                    !Objects.equals(price, book.getPrice()))
                
            book.setPrice(price);

        if(category != null &&
                category.length() > 0 &&
                    !Objects.equals(category, book.getCategory()))
                
            book.setCategory(category);

        if(language != null &&
                language.length() > 0 && 
                    !Objects.equals(language, book.getLanguage()))

            book.setLanguage(language);
    }
}
