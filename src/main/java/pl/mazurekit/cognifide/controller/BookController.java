package pl.mazurekit.cognifide.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import pl.mazurekit.cognifide.BookMapper;
import pl.mazurekit.cognifide.model.Book;
import pl.mazurekit.cognifide.service.BookService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private BookMapper bookMapper;

    private ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping(value = "/api/book/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByISBN(@PathVariable String isbn) throws JsonProcessingException {
        Book bookByISBN = bookService.findBookByISBN(isbn);
        if (bookByISBN == null) {
            throw new HttpClientErrorException(HttpStatus.NOT_FOUND, " - the book does not exist in the data set.");
        }
        return objectMapper.writeValueAsString(bookMapper.mapperBook(bookByISBN));
    }


    @RequestMapping(value = "/api/category/{categoryName}/books", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByCategoryName(@PathVariable String categoryName) throws JsonProcessingException {
        List<Book> booksByCategoryName = bookService.findBooksByCategoryName(categoryName);
        return objectMapper.writeValueAsString(bookMapper.mapperBooksList(booksByCategoryName));
    }


    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByQuery(HttpServletRequest request) throws JsonProcessingException {
        List<Book> booksByQuery = bookService.findBooksByQuery(request.getParameter("q"));
        return objectMapper.writeValueAsString(bookMapper.mapperBooksList(booksByQuery));
    }

}
