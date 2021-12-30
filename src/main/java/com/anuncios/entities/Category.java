package com.anuncios.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="\"category\"", schema ="\"anuncios\"")
public class Category implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="\"category_id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="\"category_name\"")
    private String name;

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name) {
        this.name = name;
        this.id = id;
    }

    public Category() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
