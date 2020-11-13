package com.lyq.springbootdemo.Controller;

import com.lyq.springbootdemo.Entity.Book;
import com.lyq.springbootdemo.Repository.BookRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRespository bookRespository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return bookRespository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){//利用RequestBody将前台传过来的json对象转为java对象
            Book result = bookRespository.save( book );
            if(result != null){
                return "success";
            }else{
                return "error";
            }
    }
    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id") Integer id){
        Book book1 = bookRespository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+book1);
        return book1;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Book book){//利用RequestBody将前台传过来的json对象转为java对象
        Book result = bookRespository.save( book );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id") Integer id){
        bookRespository.deleteById( id );
    }
}
