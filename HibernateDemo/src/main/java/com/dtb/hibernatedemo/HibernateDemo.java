/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.dtb.hibernatedemo;

import com.dtb.pojo.Category;
import com.dtb.repository.impl.CategoryRepositoryImpl;
import com.dtb.repository.impl.ProductRepositoryImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import org.hibernate.Session;

/**
 *
 * @author admin
 */
public class HibernateDemo {

    public static void main(String[] args) {
            
//        Map<String, String> params = new HashMap<>();
//        params.put("fromPrice","18000000");
//        params.put("toPrice","21000000");
//
//            ProductRepositoryImpl s = new ProductRepositoryImpl();
//            s.getProducts(params).forEach(p -> System.out.printf("%d - %s - %d - %s\n", 
//                    p.getId(),p.getName(), p.getPrice(), p.getCategoryId().getName()));

          CategoryRepositoryImpl s = new CategoryRepositoryImpl();
          s.getCategories().forEach(c -> System.out.println(c.getName()));

    }
}
