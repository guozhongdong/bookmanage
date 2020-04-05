package com.ngp.book.web.bookmanage;


import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
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
        PageInfo pageRequest = new PageInfo();
        List<Book> list = bookService.queryAllBook(pageRequest);
        System.out.println(list);
    }

    @Test
    public void query2All() {
        PageInfo pageRequest = new PageInfo();
        pageRequest.setPage(0);
        pageRequest.setSize(3);
        List<Book> list = bookService.queryAllBook(pageRequest);
        System.out.println(list);
    }

    @Test
    public void insertBook() {
        Book book = new Book();
        book.setAuthor("金庸");
        book.setName("鹿鼎记");
        book.setBookType("小说");
        int num = bookService.insertBook(book);
        System.out.println(num);
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
        int num = bookService.updateBook(book);
        System.out.println(num);
    }

    @Test
    public void deleteBook() {

        int num = bookService.deleteOne(1);
        System.out.println(num);
    }

}
