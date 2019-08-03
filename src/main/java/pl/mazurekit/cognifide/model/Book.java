package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import pl.mazurekit.cognifide.DateConverter;

import java.util.LinkedHashMap;
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

    private String getISBN_13Value(List<LinkedHashMap<String, String>> list) {
        for (LinkedHashMap<String, String> x : list) {
            if ("ISBN_13".equals(x.get("type"))) {
                return x.get("identifier");
            }
        }
        return null;
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

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public void setCategories(String[] categories) {
        this.categories = categories;
    }
}
