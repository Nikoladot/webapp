package com.example.simple.webapp.bootstrap;

import com.example.simple.webapp.domain.Author;
import com.example.simple.webapp.domain.Book;
import com.example.simple.webapp.domain.Publisher;
import com.example.simple.webapp.repositories.AuthorRepository;
import com.example.simple.webapp.repositories.BookRepository;
import com.example.simple.webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939556465");
        rod.getBooks().add(noEJB);
        noEJB.getAuthor().add(rod);

        Publisher laguna = new Publisher("Laguna", "Mazuraniceva 28", "Beograd", "Vozdovac", "11010");

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(laguna);


        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher's address: " + laguna.getAddress() + "\n               City: " + laguna.getCity() +
                "\n              State: " + laguna.getState() + "\n                ZIP: " + laguna.getZip());

    }
}
