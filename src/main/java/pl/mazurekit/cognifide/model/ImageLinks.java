package pl.mazurekit.cognifide.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageLinks {
    private String thumbnail;
    private String smallThumbnail;

    public ImageLinks() {
    }

    public ImageLinks(String thumbnail, String smallThumbnail) {
        this.thumbnail = thumbnail;
        this.smallThumbnail = smallThumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getSmallThumbnail() {
        return smallThumbnail;
    }

    public void setSmallThumbnail(String smallThumbnail) {
        this.smallThumbnail = smallThumbnail;
    }
}

