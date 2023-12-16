package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class DistributionService {

    @Autowired
    private DistributionRepository repository;

    public List<Distribution> selectAll() {
        List<Distribution> distributions = new ArrayList<>();
        repository.findAll().forEach(distributions::add);
        return distributions;
    }

    public Distribution whereCodename(String codename) {
        return repository.findFirstByCodename(codename);
    }

    public void insert(Distribution distribution) {
        repository.save(distribution);
    }

}
