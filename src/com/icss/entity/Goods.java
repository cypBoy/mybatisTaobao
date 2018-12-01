package com.icss.entity;

/***
 * 商品实体类
 */
public class Goods {
    private int id;
    private String no;
    private String name;
    private String type;
    private String price;

    public Goods() {
    }

    public Goods(int id, String no, String name, String type, String price) {
        this.id = id;
        this.no = no;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public Goods(String no, String name, String type, String price) {
        this.no = no;
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
