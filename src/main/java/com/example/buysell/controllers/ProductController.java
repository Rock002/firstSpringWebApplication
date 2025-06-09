package com.example.buysell.controllers;

import com.example.buysell.models.Product;
import com.example.buysell.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model) {
        model.addAttribute("products", productService.listProducts(title));
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
    public String createProduct(@RequestParam("file1") MultipartFile file1, @RequestParam("file2") MultipartFile file2,
                                @RequestParam("file3") MultipartFile file3, Product product) throws IOException {
        productService.saveProduct(product, file1, file2, file3);
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
