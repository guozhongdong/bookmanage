package com.ngp.book.web.bookmanage.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String author;

    private String publish;

    private Integer pages;

    private BigDecimal price;

    private Integer abled;

    private Date publishDate;
    /**
     * 图书类别
     * */
    private String bookType;
    /**
     * 图书总册数
     * */
    private Integer bookCount;

    /**
     * 图书描述
     * */
    private Integer bookDesc;
}
