package com.factoria.marketplace.repositories;

import com.factoria.marketplace.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where upper(p.name) like upper(concat('%', :name, '%'))")
    List<Product> findByNameContainsIgnoreCase(@Param("name") String name);
}
