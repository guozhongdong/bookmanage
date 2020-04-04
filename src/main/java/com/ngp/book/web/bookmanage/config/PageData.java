package com.ngp.book.web.bookmanage.config;


import lombok.Data;

import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 下午11:09
 */
@Data
public class PageData<T> {

    private int totalElement;

    private int totalPage;

    private int size;

    private int number;

    private List<T> content;
}
