package com.ngp.book.web.bookmanage.controller;


import com.ngp.book.web.bookmanage.config.PageData;
import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookHandler {
    @Autowired
    private BookService bookService;


    @GetMapping("/findAll/{page}/{size}")
    public PageData<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){

        PageData<Book> pageData = new PageData();
        PageInfo request = new PageInfo();
        request.setSize(size);
        request.setPage(page);
        pageData.setContent(bookService.queryAllBook(request));
        pageData.setTotalElement(bookService.queryAllBook(request).size());
        pageData.setSize(size);
        pageData.setNumber(page);
        return pageData;
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        int row = bookService.insertBook(book);
        return row+"";
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){

        return null;
    }

    @PutMapping("/update")
    public String update(@RequestBody Book book){

        return "error";

    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){


    }
}
