///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package com.vtn.repository.impl;
//
//import com.vtn.hibernate_th.HibernateUtils;
//import com.vtn.pojo.Cart;
//import com.vtn.pojo.OrderDetail;
//import com.vtn.pojo.SaleOrder;
//import java.util.Date;
//import java.util.List;
//import org.hibernate.Session;
//
///**
// *
// * @author tuann
// */
//public class ReceiptRepositoryImpl {
//
//    private static final UserRepositoryImpl user = new UserRepositoryImpl();
//    private static final ProductRepisitoryImpl product = new ProductRepisitoryImpl();
//
//    public void addReceipt(List<Cart> carts) {
//        if (carts != null) {
//            try ( Session s = HibernateUtils.getFactory().openSession()) {
//                SaleOrder order = new SaleOrder();
//                order.setUserId(user.getUserByUsername("dhthanh"));
//                order.setCreatedDate(new Date());
//                s.save(order);
//                
//                for(var c: carts) {
//                    OrderDetail d = new OrderDetail();
//                    d.setUnitPrice(c.getUnitPrice());
//                    d.setQuantity(c.getQuantity());
//                    d.setProductId(product.getProductById(c.getId()));
//                    d.setOrderId(order);
//                    s.save(d);
//                }
//            }
//
//        }
//    }
//}
