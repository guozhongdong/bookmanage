package com.ngp.book.web.bookmanage.service.impl;

import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.repository.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public int insertBook(Book book) {
        return bookMapper.insertBook(book);
    }
}
