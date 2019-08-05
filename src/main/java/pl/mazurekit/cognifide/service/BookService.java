package pl.mazurekit.cognifide.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazurekit.cognifide.BookListProvider;
import pl.mazurekit.cognifide.model.Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class BookService {

    @Autowired
    private BookListProvider bookListProvider;


    public Book findBookByISBN(String isbn) {
        for (Book book : bookListProvider.getAvailableBooks()) {
            if (isbn.equals(book.getIsbn())) {
                return book;
            }
        }
        return null;
    }

    public List<Book> findBooksByCategoryName(String category) {
        List<Book> booksWithCategory = new ArrayList<>();
        for (Book book : bookListProvider.getAvailableBooks()) {
            if (book.getCategories() != null) {
                for (String cat : book.getCategories()) {
                    if (category.toLowerCase().equals(cat.toLowerCase())) {
                        booksWithCategory.add(book);
                    }
                }
            }
        }
        return booksWithCategory;
    }


    // it checks if any of the words match
    public List<Book> findBooksByQuery(String query) {
        List<Book> booksByQuery = new ArrayList<>();
        for (Book book : bookListProvider.getAvailableBooks()) {
            if (isBookContainsAnyOfWordsFromQuery(book, query)) {
                booksByQuery.add(book);
            }
        }
        return booksByQuery;
    }


    public List<Book> findBooksOfAuthorAndHavingRating(String author) {
        List<Book> authorBooks = new ArrayList<>();
        for (Book book : bookListProvider.getAvailableBooks()) {
            if (isItBookOfAuthorAndHaveRating(author,book)) {
                authorBooks.add(book);
            }
        }
        return authorBooks;
    }

    private boolean isBookContainsAnyOfWordsFromQuery(Book book, String query) {
        List<String> words = Arrays.asList(query.split(" "));
        for (String word : words) {
            if (book.toString().toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }
        return false;
    }


    private boolean isItBookOfAuthorAndHaveRating(String author,Book book){
        if(book.getAuthors()!=null){
            if (book.getAuthors().contains(author)){
                if (book.getAverageRating()!=null){
                    if(book.getRatingsCount()!=null){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
