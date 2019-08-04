package pl.mazurekit.cognifide.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazurekit.cognifide.BookListProvider;
import pl.mazurekit.cognifide.model.Author;
import pl.mazurekit.cognifide.model.Book;

import java.util.*;

@Service
public class AuthorService {

    @Autowired
    private BookListProvider bookListProvider;

    @Autowired
    private BookService bookService;


    public List<Author> getRatingOfAuthors() {
        List<Author> authorsRatingList = new ArrayList<>();
        HashSet<String> allAuthors = getAllAuthors();
        for (String author : allAuthors) {
            List<Book> booksOfAuthorAndHavingRating = bookService.findBooksOfAuthorAndHavingRating(author);

            Double ratingOfAuthor = countRatingOfAuthor(booksOfAuthorAndHavingRating);
            if (!ratingOfAuthor.isNaN()) {
                authorsRatingList.add(new Author(author, ratingOfAuthor));
            }
        }
        return sortByRatingDescending(authorsRatingList);
    }


    private HashSet<String> getAllAuthors() {
        HashSet<String> authors = new HashSet<>();
        for (Book book : bookListProvider.getAvailableBooks()) {
            if (book.getAuthors() != null) {
                for (String author : book.getAuthors()) {
                    authors.add(author);
                }
            }
        }
        return authors;
    }

    private Double countRatingOfAuthor(List<Book> booksOfAuthor) {
        if (booksOfAuthor != null) {
            double sumOfRatings = 0.0;
            int allVotes = 0;
            for (Book book : booksOfAuthor) {
                allVotes = allVotes + book.getRatingsCount();
                sumOfRatings = sumOfRatings + book.getRatingsCount() * book.getAverageRating();
            }
            return new Double(sumOfRatings / allVotes);
        }
        return new Double(0);
    }


    private List<Author> sortByRatingDescending(List<Author> list) {
        Comparator<Author> compareByRating = (Author a1, Author a2) -> a1.getAverageRating().compareTo(a2.getAverageRating());
        Collections.sort(list, compareByRating.reversed());
        return list;
    }
}
