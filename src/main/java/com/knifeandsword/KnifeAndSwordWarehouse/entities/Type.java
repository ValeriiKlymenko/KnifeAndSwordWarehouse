package com.knifeandsword.KnifeAndSwordWarehouse.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @OneToOne(mappedBy = "type", cascade = CascadeType.ALL)
    private Material material;

    public Type(String name) {
        this.name = name;
    }
}
