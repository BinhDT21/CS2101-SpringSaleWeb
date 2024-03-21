/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.dtb.hibernatedemo;

import com.dtb.pojo.Category;
import com.dtb.pojo.Product;
import com.dtb.repository.impl.CategoryRepositoryImpl;
import com.dtb.repository.impl.ProductRepositoryImpl;
import com.dtb.repository.impl.StatsRepositoryImpl;
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

        StatsRepositoryImpl s = new StatsRepositoryImpl();

//        s.statsRevenueByProduct().forEach(item -> System.out.printf("%d - %s - %d\n", item[0], item[1], item[2]));
        s.statsRevenueByMonth(2020).forEach(item -> System.out.printf("Thang %d -> %d VND\n", item[0],item[1]));
    }
}
