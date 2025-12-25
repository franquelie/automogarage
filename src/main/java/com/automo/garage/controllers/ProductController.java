package com.automo.garage.controllers;

import com.automo.garage.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return Collections.EMPTY_LIST;
    }

    // Create Product
    @PostMapping
    public ProductDto createProduct(@RequestBody ProductDto product) {
        return null;
    }
}
