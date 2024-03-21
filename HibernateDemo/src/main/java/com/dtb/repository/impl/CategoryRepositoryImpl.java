/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtb.repository.impl;

import com.dtb.hibernatedemo.HibernateUtils;
import com.dtb.pojo.Category;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author ADMIN
 */
public class CategoryRepositoryImpl {
    public List<Category> getCategories () {
        try(Session s = HibernateUtils.getFactory().openSession()){
            Query q = s.createNamedQuery("Category.findAll");
            return q.getResultList();
        }
    }
    
    public Category getCateById (int id){
        try(Session s = HibernateUtils.getFactory().openSession()){
            
            return s.get(Category.class, id);        
            
        }
    }
    
}
