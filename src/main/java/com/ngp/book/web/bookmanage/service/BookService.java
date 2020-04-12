package com.ngp.book.web.bookmanage.service;

import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.result.ResultVO;


/**
 * @author gzd
 * @date 2020/4/4 下午3:56
 */
public interface BookService {

    ResultVO queryAllBook(PageRequest request);

    Result insertBook(Book book);

    int queryCount();

    Result updateBook(Book book);

    Result deleteOne(Integer id);

}
