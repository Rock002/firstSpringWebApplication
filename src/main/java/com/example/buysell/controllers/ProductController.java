package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(Model model) {
        model.addAttribute("products", productService.getProducts());
        return "products";
    }


    // Model model используется для передачи параметров в html / ftlh
    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-info";
    }

    // В ftlh есть форма с параметром action = "/product/create"
    // форма собирает данные и отправляет на этот адрес
    // мы с методом пост принимаем эти данные в контроллере
    @PostMapping("/product/create")
    public String createProduct(Product product) {
        productService.saveProduct(product);
        //  redirect:/ возвращает на одну страницу назад
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    //@PathVariable получает переменную из строчки выше
    public String deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return "redirect:/";
    }
}
