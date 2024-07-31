/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vtn.repository.impl;

import com.vtn.pojo.OrderDetail;
import com.vtn.pojo.Product;
import com.vtn.pojo.SaleOrder;
import com.vtn.repository.StatsRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author tuann
 */
@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {

    @Autowired
    private LocalSessionFactoryBean factory;

    @Override
    public List<Object[]> statsRevenueByProduct() {
        Session s = this.factory.getObject().getCurrentSession();
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
    @Override
    public List<Object[]> statsRevenueByPeroid(int year, String peroid) {
        Session s = this.factory.getObject().getCurrentSession();
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
