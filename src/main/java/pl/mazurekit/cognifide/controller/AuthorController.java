package pl.mazurekit.cognifide.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.mazurekit.cognifide.service.AuthorService;

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "/api/rating", method = RequestMethod.GET)
    @ResponseBody
    private String getRatingOfAuthors() throws JsonProcessingException {
        return objectMapper.writeValueAsString(authorService.getRatingOfAuthors());
    }

}
