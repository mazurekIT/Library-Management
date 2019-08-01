package pl.mazurekit.cognifide;

public class Author {
    private String fullName;
    private Double averageRating;

    public Author(String fullName, Double averageRating) {
        this.fullName = fullName;
        this.averageRating = averageRating;
    }

    public String getFullName() {
        return fullName;
    }

    public Double getAverageRating() {
        return averageRating;
    }
}
