package com.justinturney.spring5webapp.bootstrap;

import com.justinturney.spring5webapp.domain.Author;
import com.justinturney.spring5webapp.domain.Book;
import com.justinturney.spring5webapp.domain.Publisher;
import com.justinturney.spring5webapp.repositories.AuthorRepository;
import com.justinturney.spring5webapp.repositories.BookRepository;
import com.justinturney.spring5webapp.repositories.PublisherRepository;
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
        Book ddd = new Book("Domain Driven Design", "1234515235");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "46646846");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());

        Publisher penguin = new Publisher("Penguin", "123 Easy St", "", "New York", "New York", "65802");

        publisherRepository.save(penguin);
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
