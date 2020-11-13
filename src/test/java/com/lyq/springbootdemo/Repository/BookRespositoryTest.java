package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BookRespositoryTest {

    @Autowired
    private BookRespository bookRespository;

    @Test
    void findAll (){
        bookRespository.findAll();
    }

    @Test
    void save(){
        Book book =new Book();
        book.setName( "Spring Boot" );
        book.setAuthor( "zhangsan" );
        Book book1 = bookRespository.save( book );
        System.out.println(book1);
    }
    @Test
    public Book findByI(){
        Book book1 = bookRespository.findById( 1 ).get();
        System.out.println(book1);
        return book1;
    }

}