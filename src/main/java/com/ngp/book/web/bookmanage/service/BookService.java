package com.ngp.book.web.bookmanage.service;

import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.entity.Book;


import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 下午3:56
 */
public interface BookService {

    List<Book> queryAllBook(PageInfo request);

    int insertBook(Book book);
}
