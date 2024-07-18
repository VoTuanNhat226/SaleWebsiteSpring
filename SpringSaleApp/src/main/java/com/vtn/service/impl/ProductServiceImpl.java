/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.service.impl;

import com.vtn.pojo.Product;
import com.vtn.repository.ProductRepository;
import com.vtn.service.ProductService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author tuann
 */
@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepo;

    @Override
    public List<Product> getProducts(Map<String, String> params) {
      return this.productRepo.getProducts(params);
    }

    @Override
    public void addOrUpdate(Product p) {
        this.productRepo.addOrUpdate(p);
    }

    @Override
    public Product getProductById(int id) {
       return this.productRepo.getProductById(id);
    }
    
}
