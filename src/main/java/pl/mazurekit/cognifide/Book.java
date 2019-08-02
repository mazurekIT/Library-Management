package pl.mazurekit.cognifide;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;


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
    private String[] authors;
    private String[] categories;


    @SuppressWarnings("unchecked")
    @JsonProperty("volumeInfo")
    private void unpackNested(Map<String, Object> volumeInfo) {
        this.isbn = "do zrobienia";//TODO

        this.title = (String) volumeInfo.get("title");
        this.subtitle = (String) volumeInfo.get("subtitle");
        this.publisher = (String) volumeInfo.get("publisher");

//        //TODO zmiana na UNIX timestamp
//        this.publishedDate=(Long) volumeInfo.get("publishedDate");

        this.description = (String) volumeInfo.get("description");
        this.pageCount = (Integer) volumeInfo.get("pageCount");

        Map<String, String> imageLinks = (Map<String, String>) volumeInfo.get("imageLinks");
        this.thumbnailUrl = imageLinks.get("thumbnail");

        this.language = (String) volumeInfo.get("language");
        this.previewLink = (String) volumeInfo.get("previewLink");
        this.averageRating = (Double) volumeInfo.get("averageRating");
        this.ratingsCount = (Integer) volumeInfo.get("ratingsCount");

        List<String> authors = (List<String>) volumeInfo.get("authors");
        this.authors = convertListToArray(authors);

        List<String> categories = (List<String>) volumeInfo.get("categories");
        this.categories = convertListToArray(categories);

    }

    private String[] convertListToArray(List<String> list) {
        String[] listStrings = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            listStrings[i] = String.valueOf(list.get(i));
        }
        return listStrings;

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

    public String[] getAuthors() {
        return authors;
    }

    public String[] getCategories() {
        return categories;
    }
}
