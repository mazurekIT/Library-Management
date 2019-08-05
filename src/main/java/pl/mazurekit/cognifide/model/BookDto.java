package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class BookDto {

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


    public BookDto(String isbn, String title, String subtitle, String publisher, Long publishedDate, String description, Integer pageCount, String thumbnailUrl, String language, String previewLink, Double averageRating, List<String> authors, List<String> categories) {
        this.isbn = isbn;
        this.title = title;
        this.subtitle = subtitle;
        this.publisher = publisher;
        this.publishedDate = publishedDate;
        this.description = description;
        this.pageCount = pageCount;
        this.thumbnailUrl = thumbnailUrl;
        this.language = language;
        this.previewLink = previewLink;
        this.averageRating = averageRating;
        this.authors = authors;
        this.categories = categories;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(isbn, bookDto.isbn) &&
                Objects.equals(title, bookDto.title) &&
                Objects.equals(subtitle, bookDto.subtitle) &&
                Objects.equals(publisher, bookDto.publisher) &&
                Objects.equals(publishedDate, bookDto.publishedDate) &&
                Objects.equals(description, bookDto.description) &&
                Objects.equals(pageCount, bookDto.pageCount) &&
                Objects.equals(thumbnailUrl, bookDto.thumbnailUrl) &&
                Objects.equals(language, bookDto.language) &&
                Objects.equals(previewLink, bookDto.previewLink) &&
                Objects.equals(averageRating, bookDto.averageRating) &&
                Objects.equals(authors, bookDto.authors) &&
                Objects.equals(categories, bookDto.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, subtitle, publisher, publishedDate, description, pageCount, thumbnailUrl, language, previewLink, averageRating, authors, categories);
    }
}
