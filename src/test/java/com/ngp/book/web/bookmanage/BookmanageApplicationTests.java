package com.ngp.book.web.bookmanage;


import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.repository.BookRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookmanageApplicationTests {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookService bookService;

    @Test
    public void add() {
        Book book = new Book();
        book.setAuthor("金庸");
        book.setName("倚天屠龙记");
        book.setBookType("小说");
        bookRepository.save(book);
    }

    @Test
    public void edit() {
        Book book = new Book();
        book.setId(1);
        book.setAuthor("金庸");
        book.setName("倚天屠龙记2");
        book.setBookType("小说");
        bookRepository.save(book);
    }

    @Test
    public void queryAll() {

        List<Book> list = bookService.queryAllBook();
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

}
