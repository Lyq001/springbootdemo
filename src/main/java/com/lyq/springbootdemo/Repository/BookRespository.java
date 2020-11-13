package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRespository extends JpaRepository<Book,Integer> {
}
