package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

// нотация Data сама создает гетеры, сетеры и тд.
//
@Entity
@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "description", columnDefinition = "text")
    private String description;
    @Column(name = "price")
    private int price;
    @Column(name = "city")
    private String city;
    @Column(name = "author")
    private String author;

    //Один товар - несколько фотографий.
    // cascade = CascadeType.ALL  изменение ВСЕХ фогографий при удалении товара
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY,
    mappedBy = "product")
    private List<Image> images = new ArrayList<>();
    private Long previewImageId;
    private LocalDateTime dateOfCreated;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
    }

    //public Product(){}

    public void setPreviewImageId(Long previewImageId) {
        this.previewImageId = previewImageId;
    }

    public List<Image> getImages() {
        return images;
    }

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

    public void addImageToProduct(Image image) {
        image.setProduct(this);
        images.add(image);
    }
}
