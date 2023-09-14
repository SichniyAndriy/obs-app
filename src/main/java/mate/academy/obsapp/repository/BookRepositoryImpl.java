package mate.academy.obsapp.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import java.util.List;
import mate.academy.obsapp.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.resource.transaction.spi.TransactionStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryImpl implements BookRepository {
    private final SessionFactory sessionFactory;

    public BookRepositoryImpl(@Autowired SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Book save(Book book) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.persist(Book.class.getName(), book);
            transaction.commit();
        } catch (Exception e) {
            assert transaction != null;
            if (transaction.getStatus() == TransactionStatus.ACTIVE
                    && transaction.getStatus() == TransactionStatus.MARKED_ROLLBACK) {
                transaction.rollback();
            } else {
                RuntimeException rex = new RuntimeException("Rollback failed. Trace follows: ", e);
                rex.printStackTrace(System.err);
            }
            throw new RuntimeException("Cannot insert book to DB", e);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return book;
    }

    @Override
    public List<Book> findAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
            CriteriaQuery<Book> criteria = criteriaBuilder.createQuery(Book.class);
            criteria.select(criteria.from(Book.class));
            Query<Book> query = session.createQuery(criteria);
            return query.getResultList();
        } catch (Exception e) {
            throw new RuntimeException("Cannot get all books from DB", e);
        }
    }
}
