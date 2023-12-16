package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DistributionRepository extends CrudRepository<Distribution, Integer> {

    Distribution findFirstByCodename(String codename);

    @Query("select d from Distribution d where d.codename = ?1")
    Distribution whereCodename(String codename);

}
