/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dtb.pojo;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author admin
 */

@Entity
@Table(name="category")
@Getter
@Setter
public class Category implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private int id;
    
    private String name;
    private String description;
    
    @OneToMany(mappedBy = "category")
    private Set<Product> products;
}
