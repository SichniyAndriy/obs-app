package mate.academy.obsapp.service;

import java.util.List;
import mate.academy.obsapp.model.Book;

public interface BookService {
    Book save(Book book);

    List<Book> findAll();
}
