package com.cape.api.dto;

public class ProductTO {

    private String id;
    private String name;
    private String description;
    private String imageUrl;

    private int likes;

    public ProductTO( String id, String name, String description, String imageUrl, int likes ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.likes = likes;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public int getLikes() {
        return likes;
    }
}
