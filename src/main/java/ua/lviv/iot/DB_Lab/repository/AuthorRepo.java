package ua.lviv.iot.DB_Lab.repository;

import org.springframework.stereotype.Component;
import ua.lviv.iot.DB_Lab.model.Author;

@Component
public class AuthorRepo extends GeneralRepo<Author> {
    public AuthorRepo() {
        super(Author.class);
    }
}
