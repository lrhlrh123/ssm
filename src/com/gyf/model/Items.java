package com.gyf.model;

public class Items {
   private Integer id;
   private String price;
   private String detail;

    @Override
    public String toString() {
        return "Items{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
