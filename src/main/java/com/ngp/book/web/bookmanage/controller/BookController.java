package com.ngp.book.web.bookmanage.controller;



import com.ngp.book.web.bookmanage.config.PageRequest;
import com.ngp.book.web.bookmanage.entity.Book;
import com.ngp.book.web.bookmanage.result.Result;
import com.ngp.book.web.bookmanage.result.ResultVO;
import com.ngp.book.web.bookmanage.service.BookService;
import com.ngp.book.web.bookmanage.vo.BookVo;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @GetMapping("/findAll")
    public ResultVO findAll(BookVo bookVo){


        PageRequest request = new PageRequest();
        request.setSize(bookVo.getPageSize());
        request.setPage((bookVo.getPageNum()-1)*bookVo.getPageSize());
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
