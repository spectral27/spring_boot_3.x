package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DistributionController {

    @Autowired
    private DistributionService service;

    @GetMapping
    public List<Distribution> selectAll() {
        return service.selectAll();
    }

    @GetMapping("/codename")
    public Distribution selectWhereCodename(@RequestBody Map<String, String> codenameObject) {
        return service.whereCodename(codenameObject.get("codename"));
    }

    @PostMapping
    public void insert(@RequestBody Distribution distribution) {
        service.insert(distribution);
    }

}
