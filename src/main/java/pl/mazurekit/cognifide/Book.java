package pl.mazurekit.cognifide;

import java.util.List;

public class Book {
    private String isbn;
    private String title;
    private String subtitle;
    private String publisher;
    private Long publishedDate;
    private String description;
    private Integer pageCount;
    private String thumbnailUrl;
    private String language;
    private String previewLink;
    private Double averageRating;
    private List<String> authors;
    private List<String> categories;


    //TODO constructor/s



    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public String getPublisher() {
        return publisher;
    }

    public Long getPublishedDate() {
        return publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getLanguage() {
        return language;
    }

    public String getPreviewLink() {
        return previewLink;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public List<String> getCategories() {
        return categories;
    }
}
