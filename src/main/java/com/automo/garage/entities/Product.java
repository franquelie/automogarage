package com.automo.garage.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Column
    @GeneratedValue
    private UUID id;

    @Column
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false, unique = true)
    @Temporal(TemporalType.TIMESTAMP)
    private java.util.Date createdDate;

    @Column(nullable = false)
    private java.util.Date modifiedDate;

    @OneToMany(mappedBy = "produce", cascade = CascadeType.ALL)
    private List<ProductVariant> productVariants;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @PrePersist
    protected void onCreate() {
        createdDate = new java.util.Date();
        modifiedDate = createdDate;
    }
    @PreUpdate
    protected void onUpdate() {
        modifiedDate = new java.util.Date();
    }
}
