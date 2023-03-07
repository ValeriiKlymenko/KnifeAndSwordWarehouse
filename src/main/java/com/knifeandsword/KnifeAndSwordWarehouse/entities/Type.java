package com.knifeandsword.KnifeAndSwordWarehouse.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
