package com.rageash.bookshopspringbootedition.book;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookConfig {
    
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository){
        return args -> {
            Book godDelusion = new Book(
                9780552773317L,
                "God Delusion",
                "Richard Dawkins",
                "The God Delusion caused a sensation when it was published in 2006. Within weeks it became the most hotly debated topic, with Dawkins himself branded as either saint or sinner for presenting his hard-hitting, impassioned rebuttal of religion of all types. %n%nHis argument could hardly be more topical. While Europe is becoming increasingly secularized, the rise of religious fundamentalism, whether in the Middle East or Middle America, is dramatically and dangerously dividing opinion around the world. In America, and elsewhere, a vigorous dispute between 'intelligent design' and Darwinism is seriously undermining and restricting the teaching of science. In many countries religious dogma from medieval times still serves to abuse basic human rights such as women's and gay rights. And all from a belief in a God whose existence lacks evidence of any kind. %n%nDawkins attacks God in all his forms. He eviscerates the major arguments for religion and demonstrates the supreme improbability of a supreme being. He shows how religion fuels war, foments bigotry and abuses children. %n%nThe God Delusion is a brilliantly argued, fascinating polemic that will be required reading for anyone interested in this most emotional and important subject.",
                "",
                "Black Swan Book",
                464,
                BigDecimal.valueOf(144),
                "Fiction",
                "English"
            );

            Book inTheFifthAtMaloryTowers = new Book(
                9781405224079L,
                "In the Fifth at Malory Towers",
                "Enid Blyton",
                "Games, lessons, quarrels and tricks all form part of a lively term, but the biggest event of all is the Fifth Form pantomime, written, acted and produced entirely by the girls. It generates a lot of fun, but also a surprising amount of trouble. Paperback , 182 pages Published April 3rd 2006 by Egmont Books (UK) (first published 1950)",
                "",
                "Egmont",
                192,
                BigDecimal.valueOf(160),
                "Teen Fiction",
                "English"
            );

            Book sonnets = new Book(
                9780174434733L,
                "Sonnets",
                "William Shakespeare",
                "The Arden Shakespeare has long been acclaimed as the established scholarly edition of Shakespeare's work. Now being totally reedited for the third time, Arden editions offer the very best in contemporary scholarship. Each volume provides a clear and authoritative text, edited to the highest standards; detailed textual notes and commentary on the same page of the text; full contextual, illustrated introduction, including an in-depth survey of critical and performance approaches to the play; and selected bibliography.",
                "",
                "Bloomsbury Academic",
                504,
                BigDecimal.valueOf(190),
                "Classics",
                "English"
            );

            bookRepository.saveAll(
                List.of(godDelusion, inTheFifthAtMaloryTowers, sonnets)
            );
        };
    }
}
