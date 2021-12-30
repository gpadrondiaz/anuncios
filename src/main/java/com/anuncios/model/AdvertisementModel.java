package com.anuncios.model;

public class AdvertisementModel {
    private Long id;
    private String title;
    private String location;
    private String description;
    private Long subcategoryId;
    private Long categoryId;

    public AdvertisementModel() {
    }

    public AdvertisementModel(Long id, String title, String location, String description, Long subcategoryId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
    }

    public AdvertisementModel(Long id, String title, String location, String description) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
