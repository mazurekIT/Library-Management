package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.mazurekit.cognifide.DateConverter;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Book {
    private String id;
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

    //need to count average rating of authors
    private Integer ratingsCount;
    private List<String> authors;
    private List<String> categories;


    @SuppressWarnings("unchecked")
    @JsonProperty("volumeInfo")
    private void unpackNested(Map<String, Object> volumeInfo) {

        List<LinkedHashMap<String, String>> list = (List<LinkedHashMap<String, String>>) volumeInfo.get("industryIdentifiers");
        this.isbn = getISBN_13Value(list);


        this.title = (String) volumeInfo.get("title");
        this.subtitle = (String) volumeInfo.get("subtitle");
        this.publisher = (String) volumeInfo.get("publisher");

        DateConverter publishedDate = new DateConverter((String) volumeInfo.get("publishedDate"));
        this.publishedDate = publishedDate.getUnixTimestamp();

        this.description = (String) volumeInfo.get("description");
        this.pageCount = (Integer) volumeInfo.get("pageCount");

        Map<String, String> imageLinks = (Map<String, String>) volumeInfo.get("imageLinks");
        this.thumbnailUrl = imageLinks.get("thumbnail");

        this.language = (String) volumeInfo.get("language");
        this.previewLink = (String) volumeInfo.get("previewLink");
        this.averageRating = (Double) volumeInfo.get("averageRating");
        this.ratingsCount = (Integer) volumeInfo.get("ratingsCount");
        this.authors  = (List<String>) volumeInfo.get("authors");
        this.categories = (List<String>) volumeInfo.get("categories");
    }



    private String getISBN_13Value(List<LinkedHashMap<String, String>> list) {
        if (list == null) {
            return null;
        }

        for (LinkedHashMap<String, String> x : list) {
            if ("ISBN_13".equals(x.get("type"))) {
                return x.get("identifier");
            }
        }
        return this.getId();
    }


    public Book() {
    }

    public Book(String id, String isbn, String title, String subtitle, String publisher, Long publishedDate, String description, Integer pageCount, String thumbnailUrl, String language, String previewLink, Double averageRating, Integer ratingsCount, List<String> authors, List<String> categories) {
        this.id = id;
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
        this.ratingsCount = ratingsCount;
        this.authors = authors;
        this.categories = categories;
    }

    public String getId() {
        return id;
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

    public Integer getRatingsCount() {
        return ratingsCount;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishedDate(Long publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPreviewLink(String previewLink) {
        this.previewLink = previewLink;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public void setRatingsCount(Integer ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishedDate=" + publishedDate +
                ", description='" + description + '\'' +
                ", pageCount=" + pageCount +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", language='" + language + '\'' +
                ", previewLink='" + previewLink + '\'' +
                ", averageRating=" + averageRating +
                ", ratingsCount=" + ratingsCount +
                ", authors=" + authors +
                ", categories=" + categories +
                '}';
    }
}
