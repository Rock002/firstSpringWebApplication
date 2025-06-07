package com.example.buysell.models;

import lombok.AllArgsConstructor;
import lombok.Data;

// нотация Data сама создает гетеры, сетеры и тд.
//
@Data
@AllArgsConstructor
public class Product {
    private Long id;
    private String title;
    private String description;
    private int price;
    private String city;
    private String author;

    public Product(){}

    public void setTitle(Long ID, String title, String description) {
        this.title = title;
        this.description = description;
        this.id = ID;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public String getCity() {
        return city;
    }

    public String getAuthor() {
        return author;
    }
}
