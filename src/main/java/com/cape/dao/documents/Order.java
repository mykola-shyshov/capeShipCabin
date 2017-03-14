package com.cape.dao.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document( collection = "orders" )
public class Order {

    @Id
    private String id;

    private String name;
    private String phone;
    private String productId;
    private String customOrderDescription;

    // captain fields
    private Double price;
    private OrderStatus orderStatus;
    private String remark;

    public Order(
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

    public Order(
          String name,
          String phone,
          String productId,
          String customOrderDescription,
          Double price,
          OrderStatus orderStatus,
          String remark
    ) {
        this.name = name;
        this.phone = phone;
        this.productId = productId;
        this.customOrderDescription = customOrderDescription;
        this.price = price;
        this.orderStatus = orderStatus;
        this.remark = remark;
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

    public Double getPrice() {
        return price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getRemark() {
        return remark;
    }

    public String getId() {
        return id;
    }
}
