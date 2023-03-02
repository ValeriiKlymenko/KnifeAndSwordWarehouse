package com.knifeandsword.KnifeAndSwordWarehouse.services;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Iron;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.IronRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IronService {

    public final IronRepository ironRepository;

    public IronService(IronRepository ironRepository) {
        this.ironRepository = ironRepository;
    }

    public List<Iron> listIron() {
        return ironRepository.findAll();
    }
}
