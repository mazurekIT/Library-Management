package pl.mazurekit.cognifide.controlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mazurekit.cognifide.BookListProvider;
import pl.mazurekit.cognifide.model.Book;

import java.util.List;

@Controller
public class Hello {

    @Autowired
    private BookListProvider bookListProvider;

    @RequestMapping("/a")
    public String hello() {
        List<Book> availableBooks = bookListProvider.getAvailableBooks();
        String s = "";
        for (Book x:availableBooks){
            s= s + x.getId() + " - "+ x.getIsbn()+"<br>";
        }


        return "Hello <br>" + s ;
    }
}