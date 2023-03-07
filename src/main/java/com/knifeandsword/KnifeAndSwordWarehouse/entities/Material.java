package com.knifeandsword.KnifeAndSwordWarehouse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "material")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Material {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int width;//ширина мм
    private int length;//довжина мм
    private int height;//висота мм
    private int weight;//вага г
    private int amount;
    private BigDecimal price;

    @ManyToOne
    private Type type;

    public Material(String name, int width, int length, int height, int weight, int amount, BigDecimal price, Type type) {
        this.name = name;
        this.width = width;
        this.length = length;
        this.height = height;
        this.weight = weight;
        this.amount = amount;
        this.price = price;
        this.type = type;
    }
}
