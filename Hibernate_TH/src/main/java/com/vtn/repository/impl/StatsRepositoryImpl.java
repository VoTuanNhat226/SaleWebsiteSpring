/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.repository.impl;

import com.vtn.hibernate_th.HibernateUtils;
import com.vtn.pojo.OrderDetail;
import com.vtn.pojo.Product;
import com.vtn.pojo.SaleOrder;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author tuann
 */
public class StatsRepositoryImpl {

    public List<Object[]> statsRevenueByProduct() {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootProduct = q.from(Product.class);
            Root rootOrderDetail = q.from(OrderDetail.class);

            q.where(b.equal(rootProduct.get("id"), rootOrderDetail.get("productId")));

            q.multiselect(rootProduct.get("id"), rootProduct.get("name"), b.sum(b.prod(rootOrderDetail.get("quantity"), rootOrderDetail.get("unitPrice"))));
            q.groupBy(rootProduct.get("id"));

            Query query = s.createQuery(q);

            return query.getResultList();
        }
    }

    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
        try ( Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rootSaleOrder = q.from(SaleOrder.class);
            Root rootOrderDetail = q.from(OrderDetail.class);

            q.where(b.equal(rootSaleOrder.get("id"), rootOrderDetail.get("orderId")), b.equal(b.function("YEAR", Integer.class, rootSaleOrder.get("createdDate")), year));

            q.multiselect(b.function(peroid, Integer.class, rootSaleOrder.get("createdDate")), b.sum(b.prod(rootOrderDetail.get("quantity"), rootOrderDetail.get("unitPrice"))));
            q.groupBy(b.function(peroid, Integer.class, rootSaleOrder.get("createdDate")));

            Query query = s.createQuery(q);

            return query.getResultList();
        }
    }
}
