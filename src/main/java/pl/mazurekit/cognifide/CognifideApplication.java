package pl.mazurekit.cognifide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CognifideApplication {

    public static void main(String[] args) {
        SpringApplication.run(CognifideApplication.class, args);

        BookListProvider bookListProvider = new JSONBookListProvider("C:\\Users\\Mazzi\\Desktop\\cognifide\\src\\main\\resources\\books.json");

        bookListProvider.getAvailableBooks();
    }

}
