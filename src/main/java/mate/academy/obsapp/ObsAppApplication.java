package mate.academy.obsapp;

import java.math.BigDecimal;
import mate.academy.obsapp.model.Book;
import mate.academy.obsapp.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ObsAppApplication {
    @Autowired
    private BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(ObsAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            Book book = new Book();
            book.setTitle("bbb");
            book.setAuthor("aaaa");
            book.setIsbn("asdfg");
            book.setPrice(BigDecimal.valueOf(1029));
            book.setDescription("qwertyuiop");
            book.setCoverImage("sdsd");
            bookService.save(book);
            System.out.println(bookService.findAll());
        };
    }
}
