package com.ngp.book.web.bookmanage.repository;

import com.ngp.book.web.bookmanage.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
}
