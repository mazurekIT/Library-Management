package pl.mazurekit.cognifide.controlller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.mazurekit.cognifide.service.BookService;

import javax.servlet.http.HttpServletRequest;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    ObjectMapper objectMapper = new ObjectMapper();


    @RequestMapping(value = "/api/book/{isbn}", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByISBN(@PathVariable String isbn) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.findBookByISBN(isbn));

    }


    @RequestMapping(value = "/api/category/{categoryName}/books", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByCategoryName(@PathVariable String categoryName) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.findBooksByCategoryName(categoryName));
    }


    @RequestMapping(value = "/api/search", method = RequestMethod.GET)
    @ResponseBody
    private String getBookByQuery(HttpServletRequest request) throws JsonProcessingException {
        return objectMapper.writeValueAsString(bookService.findBooksByQuery(request.getParameter("q")));
    }

}
