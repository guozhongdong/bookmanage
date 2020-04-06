package com.ngp.book.web.bookmanage.service.impl;

import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 下午3:57
 *
 */
@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Override
    public PageInfo queryAllBook(PageRequest request) {
        List<Book> list = bookMapper.queryAllBook(request);
        int count = bookMapper.queryCount();
        return new PageInfo(true,null,request.getPage(),request.getSize(),list,count);
    }

    @Override
    public Result insertBook(Book book) {
        Result result = new Result();
        result.setResult(bookMapper.insertBook(book));
        return result;
    }

    @Override
    public int queryCount() {

        return bookMapper.queryCount();

    }

    @Override
    public Result updateBook(Book book) {

        Result result = new Result();
        result.setResult(bookMapper.updateBook(book));
        return result;
    }

    @Override
    public Result deleteOne(Integer id) {
        Result result = new Result();
        result.setResult(bookMapper.deleteOne(id));
        return result;
    }
}
