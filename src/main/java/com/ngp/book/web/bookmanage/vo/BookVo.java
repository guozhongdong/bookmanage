package com.ngp.book.web.bookmanage.vo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookVo {

    private Integer pageNum;

    private Integer pageSize;

    private Integer id;

    private String name;

    private String author;

    private String publish;

    private Integer pages;

    private BigDecimal price;

    /**
     * 是否有效
     * */
    private Integer abled;

    /**
     * 发布日期
     * */
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
