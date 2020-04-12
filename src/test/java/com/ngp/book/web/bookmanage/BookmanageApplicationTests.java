package com.ngp.book.web.bookmanage;


import com.alibaba.fastjson.JSONObject;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.result.ResultVO;
import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class BookmanageApplicationTests {


    @Autowired
    private BookService bookService;

    @Test
    public void add() {
        Book book = new Book();
        book.setAuthor("金庸");
        book.setName("倚天屠龙记");
        book.setBookType("小说");

    }

    @Test
    public void edit() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("金庸");
        book.setName("倚天屠龙记2");
        book.setBookType("小说");

    }

    @Test
    public void queryAll() {
        PageRequest pageRequest = new PageRequest();
        ResultVO result = bookService.queryAllBook(pageRequest);
        log.info("分页查询结果为："+ JSONObject.toJSON(result));
    }

    @Test
    public void query2All() {
        PageRequest pageRequest = new PageRequest();
        pageRequest.setPage(0);
        pageRequest.setSize(3);
        ResultVO result = bookService.queryAllBook(pageRequest);
        log.info("分页查询结果为："+ JSONObject.toJSON(result));
    }

    @Test
    public void insertBook() {
        Book book = new Book();
        book.setAuthor("金庸");
        book.setName("鹿鼎记");
        book.setBookType("小说");
        Result result = bookService.insertBook(book);
        log.info("新增结果为："+ JSONObject.toJSON(result));
    }

    @Test
    public void updateBook() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("金庸");
        book.setName("倚天屠龙记222");
        book.setPublish("机械工业出版社");
        book.setBookType("小说2");
        book.setPages(900);
        Result result = bookService.updateBook(book);
        log.info("修改结果为："+ JSONObject.toJSON(result));
    }

    @Test
    public void deleteBook() {

        Result result = bookService.deleteOne(1);
        log.info("删除结果为："+ JSONObject.toJSON(result));
    }

}
