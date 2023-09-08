package mate.academy.obsapp.service;

import java.util.List;
import mate.academy.obsapp.model.Book;
import mate.academy.obsapp.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    public BookServiceImpl(@Autowired BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save( book );
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }
}
