package pl.mazurekit.cognifide.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AuthorTest {


    @Test
    public void creat() {
        Author author = new Author("A. B.", new Double(4.3));
        assertEquals("A. B.", author.getName());
        assertEquals(new Double(4.3), author.getAverageRating());
    }

}