package com.example.buysell.services;

import com.example.buysell.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> products = new ArrayList<>();
    private long ID = 0;
    {
        Product first = new Product();
        first.setTitle(++ID,"PlayStation 5", "d");
        products.add(first);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void saveProduct(Product product) {
        product.setId(++ID);
        products.add(product);
    }

    public void delete (Long ID) {
        products.removeIf(product -> product.getId().equals(ID));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
