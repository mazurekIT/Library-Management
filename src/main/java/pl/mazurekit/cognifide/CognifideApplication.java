package pl.mazurekit.cognifide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.mazurekit.cognifide.model.Book;

import java.util.List;

@SpringBootApplication
public class CognifideApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognifideApplication.class, args);

        BookListProvider bookListProvider = new JSONBookListProvider("books.json");

        List<Book> availableBooks = bookListProvider.getAvailableBooks();

        for (Book x:availableBooks){
            System.out.println(x.getId()+" - "+ x.getIsbn());
        }
    }

}
