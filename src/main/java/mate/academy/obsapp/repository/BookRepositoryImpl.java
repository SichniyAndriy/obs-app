package mate.academy.obsapp.repository;

import java.util.List;
import mate.academy.obsapp.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    @Override
    public Book save(Book book) {
        return null;
    }

    @Override
    public List<Book> findAll() {
        return null;
    }
}
