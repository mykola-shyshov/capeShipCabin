package com.cape.api.dto;

public class OrderTO {

    private String id;
    private String name;
    private String phone;
    private String productId;
    private String customOrderDescription;

    public OrderTO() {
    }

    public OrderTO(
            String id,
            String name,
            String phone,
            String productId,
            String customOrderDescription
    ) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.productId = productId;
        this.customOrderDescription = customOrderDescription;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getProductId() {
        return productId;
    }

    public String getCustomOrderDescription() {
        return customOrderDescription;
    }
}
