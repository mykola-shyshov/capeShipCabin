package com.cape.dao.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "goods" )
public class Product {

    @Id
    private String id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;

    private int likes;

    // captain fields
    private Double margin;
    private String distribution;

    public Product() {
    }

    public Product(
            String id,
            String name,
            Double price,
            String description,
            String imageUrl,
            Double margin,
            String distribution,
            int likes
    ) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.margin = margin;
        this.distribution = distribution;
        this.likes = likes;
    }

    public Double getMargin() {
        return margin;
    }

    public String getDistribution() {
        return distribution;
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

    public Double getPrice() {
        return price;
    }

}
