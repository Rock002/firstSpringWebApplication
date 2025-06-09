package com.example.buysell.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "images")
@NoArgsConstructor
@AllArgsConstructor
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "originalFileName")
    private String originalFileName;
    @Column(name = "size")
    private Long size;
    @Column(name = "contentType")
    private String contentType;
    @Column(name = "isPreviewImage")
    private boolean isPreviewImage;
    @Column(columnDefinition = "LONGBLOB")
    private byte[] bytes;

    //Множество фотографий к одному товару
    // cascade = CascadeType.REFRESH  -  обновление
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    private Product product;

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Long getSize() {
        return size;
    }

    public String getContentType() {
        return contentType;
    }

    public boolean isPreviewImage() {
        return isPreviewImage;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public Product getProduct() {
        return product;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public Long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOriginalFileName(String originalFileName) {
        this.originalFileName = originalFileName;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPreviewImage(boolean previewImage) {
        isPreviewImage = previewImage;
    }

    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
