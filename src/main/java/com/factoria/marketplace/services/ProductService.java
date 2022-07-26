package com.factoria.marketplace.services;

import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.repositories.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepository productRepository;

    public ProductService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }


    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }


}
