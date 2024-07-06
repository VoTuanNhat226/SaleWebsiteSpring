/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.repository.impl;

import com.vtn.hibernate_th.HibernateUtils;
import com.vtn.pojo.Category;
import com.vtn.pojo.Product;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
/**
 *
 * @author admin
 */
public class ProductRepositoryImpl {
     public List<Product> getProduct() {
      try(Session s = HibernateUtils.getFactory().openSession()) {
          Query q = s.createQuery("From Product");
          return q.getResultList();
      }
  }
}
