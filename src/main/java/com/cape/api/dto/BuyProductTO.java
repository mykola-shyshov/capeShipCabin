package com.cape.api.dto;

public class BuyProductTO {

    private String name;
    private String phone;
    private String productId;
    private String customOrderDescription;

    public BuyProductTO(
           String name,
           String phone,
           String productId,
           String customOrderDescription
    ) {
        this.name = name;
        this.phone = phone;
        this.productId = productId;
        this.customOrderDescription = customOrderDescription;
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
