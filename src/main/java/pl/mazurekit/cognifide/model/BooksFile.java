package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BooksFile {
    private List<Book> items;

    public BooksFile(List<Book> items) {
        this.items = items;
    }

    public BooksFile() {
    }

    public List<Book> getItems() {
        return items;
    }

    public void setItems(List<Book> items) {
        this.items = items;
    }
}
