package com.ngp.book.web.bookmanage.repository;

import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author gzd
 * @date 2020/4/4 下午3:53
 */
public interface BookMapper {

    List<Book> queryAllBook(@Param("pageRequest") PageRequest pageRequest);

    int insertBook(@Param("book") Book book);

    /**
     * 查询总条数
     * */
    int queryCount();

    int updateBook(@Param("book") Book book);

    int deleteOne(Integer id);
}
