package com.anuncios.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="\"subcategory\"", schema ="\"anuncios\"")
public class SubCategory implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "\"subcategory_id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "\"subcategory_name\"")
    private String name;

    @Column(name = "\"category_id\"")
    private Long categoryId;

    public SubCategory(String name, Long categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubCategory(Long id, String name, Long categoryId) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
    }

    public SubCategory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}

