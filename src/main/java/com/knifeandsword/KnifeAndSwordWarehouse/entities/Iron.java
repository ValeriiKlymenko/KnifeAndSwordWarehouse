package com.knifeandsword.KnifeAndSwordWarehouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "iron")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Iron {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int width;//ширина мм
    private int height;//висота мм
    private int length;//довжина мм
    private int weight;//вага г
    private BigDecimal price;

}
