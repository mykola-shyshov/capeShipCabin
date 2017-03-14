package com.cape.api.dto;

import com.cape.dao.documents.OrderStatus;

public class CaptainOrderTO {

    private String id;

    private String name;
    private String phone;
    private String productId;
    private String customOrderDescription;

    private Double price;
    private OrderStatus orderStatus;
    private String remark;

    public CaptainOrderTO(
           String id,
           String name,
           String phone,
           String productId,
           String customOrderDescription,
           Double price,
           OrderStatus orderStatus,
           String remark
    ) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.productId = productId;
        this.customOrderDescription = customOrderDescription;
        this.price = price;
        this.orderStatus = orderStatus;
        this.remark = remark;
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

    public Double getPrice() {
        return price;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getRemark() {
        return remark;
    }
}
