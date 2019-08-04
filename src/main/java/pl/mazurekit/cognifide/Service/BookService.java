package pl.mazurekit.cognifide.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.mazurekit.cognifide.BookListProvider;
import pl.mazurekit.cognifide.model.Book;

import java.util.ArrayList;
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


    public List<Book> findBooksByQuery(String query){
        List<Book> booksByQuery = new ArrayList<>();
        for (Book book : bookListProvider.getAvailableBooks()) {
            System.out.println(book.toString());
            String bookString=book.toString();
            if(bookString.toLowerCase().contains(query.toLowerCase())){
                booksByQuery.add(book);
            }
        }
        return booksByQuery;
    }

}
