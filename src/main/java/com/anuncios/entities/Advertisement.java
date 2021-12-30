package com.anuncios.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="\"advertisement\"", schema ="\"anuncios\"")
public class Advertisement implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="\"adv_id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="\"adv_title\"")
    private String title;

    @Column(name="\"adv_location\"")
    private String location;

    @Column(name="\"adv_description\"")
    private String description;

    @Column(name = "\"adv_subcategory\"")
    private Long subcategoryId;

    @Column(name = "\"adv_category\"")
    private Long categoryId;

    public Advertisement(Long id, String title, String location, String description, Long subcategoryId, Long categoryId) {
        this.id = id;
        this.title = title;
        this.location = location;
        this.description = description;
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
    }

    public Advertisement(String title, String location, String description, Long subcategoryId, Long categoryId) {
        this.title = title;
        this.location = location;
        this.description = description;
        this.subcategoryId = subcategoryId;
        this.categoryId = categoryId;
    }

    public Advertisement() {
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
