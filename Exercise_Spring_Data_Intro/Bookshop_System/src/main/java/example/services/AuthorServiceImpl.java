package example.services;

import example.entities.Author;
import example.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    @Autowired
    AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Author getRandomAuthor() {
        long size = this.authorRepository.count();
        int authorId = new Random().nextInt((int) size) + 1;
        return this.authorRepository.findById(authorId).get();
    }
}
