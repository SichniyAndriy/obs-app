package mate.academy.obsapp.repository;

import java.util.List;
import mate.academy.obsapp.model.Book;

public interface BookRepository {
    Book save(Book book);

    List<Book> findAll();
}
