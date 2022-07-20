package com.factoria.marketplace.services;

import com.factoria.marketplace.dto.ProductRequestDto;
import com.factoria.marketplace.models.Product;
import com.factoria.marketplace.models.User;
import com.factoria.marketplace.repositories.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
class ProductServiceTest {

    @Mock
    IProductRepository productRepository;

    @Test
    void getAllReturnsAListProducts() {
        var productService = new ProductService(productRepository);
        var productList = List.of(new Product(), new Product());

        Mockito.when(productRepository.findAll()).thenReturn(productList);

        var sut = productService.getAll();

        assertThat(sut.size(), equalTo(2));
        //assertThat(sut.size(), equalTo(1));
    }

    @Test
    void createSaveAProductMappedFromDTO() {
        var productService = new ProductService(productRepository);

        var productRequest = new ProductRequestDto("Bici", "asdas.jpg", 600.3);
        var seller = new User();
        seller.setId(1L);


        //se debe crear funcion producto y llamarla
        var product = new Product();
        product.setName("Bici");
        product.setImg("asdas.jpg");
        product.setId(1L);
        product.setSeller(seller);
        product.setPrice(600.3);


        Mockito.when(productRepository.save(any(Product.class))).thenReturn(product);

        var sut = productService.create(productRequest, seller);

        //testejar que el del producte coincideixi amb el seller
        assertThat(sut.getSeller(), equalTo(seller));
    }
}