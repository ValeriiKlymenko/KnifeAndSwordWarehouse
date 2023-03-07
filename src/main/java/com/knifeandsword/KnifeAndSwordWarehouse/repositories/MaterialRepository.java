package com.knifeandsword.KnifeAndSwordWarehouse.repositories;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
