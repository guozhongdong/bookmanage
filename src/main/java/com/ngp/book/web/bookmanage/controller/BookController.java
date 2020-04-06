package com.ngp.book.web.bookmanage.controller;


import com.ngp.book.web.bookmanage.config.PageInfo;
import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/findAll/{page}/{size}")
    public PageInfo findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){


        PageRequest request = new PageRequest();
        request.setSize(size);
        request.setPage((page-1)*size);
        return bookService.queryAllBook(request);
    }

    @PostMapping("/save")
    public Result save(@RequestBody Book book){

        return bookService.insertBook(book);
    }

    @GetMapping("/findById/{id}")
    public Result findById(@PathVariable("id") Integer id){

        return null;
    }

    @PostMapping("/update")
    public Result update(@RequestBody Book book){

        return bookService.updateBook(book);

    }

    @GetMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        return bookService.deleteOne(id);

    }
}
