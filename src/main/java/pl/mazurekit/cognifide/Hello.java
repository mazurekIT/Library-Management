package pl.mazurekit.cognifide;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
    @RequestMapping("/a")
    public String hello() {
        return "Hello";
    }
}
