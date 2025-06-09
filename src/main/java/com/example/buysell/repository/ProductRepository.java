package com.example.buysell.repository;

import com.example.buysell.models.Product;
// Получение доступа к функциям crud в базе
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //jpa сам определить тело этой функции
    List<Product> findByTitle(String title);
}
