package com.cape.api.dto;

public class CaptainProductTO {

    private String id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

    private int likes;

    // for captain
    private Double margin;
    private String distribution;

    public CaptainProductTO(
             String id,
             String name,
             Double price,
             String description,
             String imageUrl,
             int likes,
             Double margin,
             String distribution
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.likes = likes;
        this.margin = margin;
        this.distribution = distribution;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
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

    public Double getMargin() {
        return margin;
    }

    public String getDistribution() {
        return distribution;
    }
}
