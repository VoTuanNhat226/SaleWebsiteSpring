/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.vtn.hibernate_th;

import com.vtn.pojo.Cart;
import com.vtn.repository.impl.CategoryRepositoryImpl;
import com.vtn.repository.impl.ProductRepisitoryImpl;
import com.vtn.repository.impl.ReceiptRepositoryImpl;
import com.vtn.repository.impl.StatsRepositoryImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tuann
 */
public class Hibernate_TH {

    public static void main(String[] args) {
            StatsRepositoryImpl s = new StatsRepositoryImpl();
            s.statsRevenueByPeroid(2020, "QUARTER").forEach(o -> System.out.printf("%s: %d\n", o[0],o[1]));
        
//        List<Cart> carts = new ArrayList<>();
//        carts.add(new Cart(1, "A",2, 100l));
//        
//        ReceiptRepositoryImpl receipt = new ReceiptRepositoryImpl();
//        receipt.addReceipt(carts);
        
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCategory().forEach(c -> System.out.println(c.getName()));
//
//        Map<String, String> params = new HashMap<>();
//        params.put("q", "iPhone");
//        params.put("fromPrice", "17000000");
//        params.put("toPrice", "30000000");
//        params.put("page", "2");
        
//        ProductRepisitoryImpl s = new ProductRepisitoryImpl();
//        s.getProducts(null).forEach(p -> System.out.printf("%s - %.1f\n", p.getName(), p.getPrice()));
    }
}
