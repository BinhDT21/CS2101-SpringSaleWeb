/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtb.repository.impl;

import com.dtb.hibernatedemo.HibernateUtils;
import com.dtb.pojo.OrderDetail;
import com.dtb.pojo.Product;
import com.dtb.pojo.SaleOrder;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class StatsRepositoryImpl {

    //doanh thu theo sản phẩm
    public List<Object[]> statsRevenueByProduct() {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rP = q.from(Product.class);
            Root rD = q.from(OrderDetail.class);

            q.multiselect(rP.get("id"), rP.get("name"), b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(b.equal(rP.get("id"), rD.get("productId")));
            
            
            q.where(predicates.toArray(Predicate[]::new));
            q.groupBy(rP.get("id"));

//            q.where(predicates.toArray(Predicate[]::new));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }

    //doanh thu theo quý
    public List<Object[]> statsRevenueByMonth(int year) {
        try (Session s = HibernateUtils.getFactory().openSession()) {
            CriteriaBuilder b = s.getCriteriaBuilder();
            CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

            Root rD = q.from(OrderDetail.class);
            Root rSO = q.from(SaleOrder.class);

            q.multiselect(b.function("MONTH",Integer.class, rSO.get("createdDate")), b.sum(b.prod(rD.get("unitPrice"), rD.get("quantity"))));

            List<Predicate> predicates = new ArrayList<>();
            predicates.add(b.equal(rSO.get("id"), rD.get("orderId")));
            predicates.add(b.equal(b.function("YEAR",Integer.class, rSO.get("createdDate")), year));
            
            
            q.where(predicates.toArray(Predicate[]::new));
            q.groupBy(b.function("MONTH",Integer.class, rSO.get("createdDate")));

//            q.where(predicates.toArray(Predicate[]::new));
            
            Query query = s.createQuery(q);
            return query.getResultList();
        }
    }

}
