package com.example.udemy.bootstrap;

import com.example.udemy.domain.Author;
import com.example.udemy.domain.Book;
import com.example.udemy.repositories.AuthorRepository;
import com.example.udemy.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author Pra = new Author("Pranita","Deshmukh");
        Book b1 = new Book("DDD", "1234");
        Pra.getBook().add(b1);
        b1.getAuthors().add(Pra);
        authorRepository.save(Pra);
        bookRepository.save(b1);

        Author Chin = new Author("Chinn","Vijay");
        Book b2 = new Book("Stats","23");
        Chin.getBook().add(b2);
        b2.getAuthors().add(Chin);
        authorRepository.save(Chin);
        bookRepository.save(b2);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: "+ bookRepository.count());
    }
}
