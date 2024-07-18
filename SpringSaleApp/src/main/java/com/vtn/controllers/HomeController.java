/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.controllers;

//import javax.persistence.Query;
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
//import org.springframework.stereotype.Controller;
//import org.springframework.transaction.annotation.Transactional;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
import com.vtn.service.CategoryService;
import com.vtn.service.ProductService;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author tuann
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService cateService;
    
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam Map<String, String> params) {

        model.addAttribute("categorys", this.cateService.getCategory());
        model.addAttribute("products", this.productService.getProducts(params));

        return "index";
    }
}
