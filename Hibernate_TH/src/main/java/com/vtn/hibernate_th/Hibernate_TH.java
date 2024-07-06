/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.vtn.hibernate_th;

import com.vtn.repository.impl.CategoryRepositoryImpl;
import com.vtn.repository.impl.ProductRepositoryImpl;

/**
 *
 * @author admin
 */
public class Hibernate_TH {

    public static void main(String[] args) {
//        CategoryRepositoryImpl s = new CategoryRepositoryImpl();
//        s.getCate().forEach(c -> System.out.println(c.getName()));

        ProductRepositoryImpl p = new ProductRepositoryImpl();
        p.getProduct().forEach(c -> System.out.println(c.getPrice()));
    }
}
