package com.example.tryingOpenShift.service;

import org.springframework.stereotype.Service;

@Service
public class SellProductService {
    public String sellProduct() {
        return "Product sold";
    }
}
