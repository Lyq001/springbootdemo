package com.lyq.springbootdemo.Controller;

import com.lyq.springbootdemo.Entity.Image;
import com.lyq.springbootdemo.Repository.ImageRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/image")
public class ImageController {

    @Autowired
    private ImageRespository imageRespository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Image> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return imageRespository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Image image){
        File file = new File("C:\\Users\\Shinelon\\Pictures\\Saved Pictures\\timg.jpg");
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
            image.setFile_name( "01" );
            image.setContent( multipartFile.getBytes() );
            image.setGroup_01( "A" );
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    @PostMapping("/download")
    public void download(@RequestBody Image image){
        byte[] get_image;
        try {
            //将读取到的图片存放到指定的路径中
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Shinelon\\Pictures\\Screenshots\\bb.jpg");
            //Image image = new Image();
            image.setId( 2 );
            Example<Image> example = Example.of(image);
            Image image1 = imageRespository.findOne( example ).get();
            if (!image1.toString().isEmpty()) {
                get_image = image1.getContent();
                //将读取到的File对象转成字节流
                //InputStream inputStream = new FileInputStream( get_image );
                InputStream inputStream = new ByteArrayInputStream(get_image);
                int a;
                byte b[] = new byte[2048];
                while ((a = inputStream.read(b)) != -1) {
                    fileOutputStream.write(b, 0, a);
                }
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
