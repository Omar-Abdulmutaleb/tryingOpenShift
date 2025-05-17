package com.example.tryingOpenShift.controller;

import com.example.tryingOpenShift.service.SellProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

private final SellProductService sellProductService;

    public ProductController(SellProductService sellProductService) {
        this.sellProductService = sellProductService;
    }

    @GetMapping
    public String getProduct() {
        return sellProductService.sellProduct();
    }
}
