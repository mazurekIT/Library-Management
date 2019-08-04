package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Author {
    private String name;
    private Double averageRating;

    public Author(String name, Double averageRating) {
        this.name = name;
        this.averageRating = averageRating;
    }

    public Author() {
    }

    public String getName() {
        return name;
    }

    public Double getAverageRating() {
        return averageRating;
    }
}
