package com.ngp.book.web.bookmanage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.result.ResultVO;
import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.repository.BookMapper;
import com.ngp.book.web.bookmanage.utils.CommonUtil;
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
    public ResultVO queryAllBook(PageRequest request) {
        ResultVO resultVO = ResultVO.successRes();
        List<Book> list = bookMapper.queryAllBook(request);
        int count = bookMapper.queryCount();

        ResultVO.ResultData resultData = new ResultVO.ResultData();
        resultData.setDatalist(list);
        resultData.setPageSize(request.getSize());
        resultData.setTotalCount(count);
        resultVO.setInfo(resultData);
        return resultVO;
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
