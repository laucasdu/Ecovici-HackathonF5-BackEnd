package com.factoria.marketplace.controllers;


import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.services.IProductService;
import com.factoria.marketplace.services.IUserService;
import com.factoria.marketplace.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {

    private IProductService productService;
    private IUserService userService;

    public ProductController(IProductService productService, IUserService userService) {
        this.productService = productService;
        this.userService = userService;
    }

    @GetMapping("/products")
    List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/products/{id}")
    Product getById(@PathVariable Long id) {
        return productService.findById(id);
    }



}
