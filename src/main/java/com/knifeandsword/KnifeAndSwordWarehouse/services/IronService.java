package com.knifeandsword.KnifeAndSwordWarehouse.services;

import com.knifeandsword.KnifeAndSwordWarehouse.entities.Iron;
import com.knifeandsword.KnifeAndSwordWarehouse.repositories.IronRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IronService {

    public final IronRepository ironRepository;

    public IronService(IronRepository ironRepository) {
        this.ironRepository = ironRepository;
    }

}
