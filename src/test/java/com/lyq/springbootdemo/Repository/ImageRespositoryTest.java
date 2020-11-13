package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Entity.Image;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.NoSuchElementException;

@SpringBootTest
class ImageRespositoryTest {

    @Autowired
    private ImageRespository imageRespository;

    @Test
    void save(){
        File file = new File("C:\\Users\\Shinelon\\Pictures\\Saved Pictures\\timg1.jpg");
        try {
            //FileItemFactory factory = new DiskFileItemFactory(16,null);
            //FileItem item = factory.createItem( file.getName(),"text/plain",true,file.getName() );
            //MultipartFile multipartFile = new CommonsMultipartFile( item );
            FileInputStream fileInputStream = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile(file.getName(), fileInputStream);
            Image image = new Image();
            image.setFile_name( "01" );
            image.setContent(multipartFile.getBytes() );
            image.setGroup_01( "A" );
            Image result = imageRespository.save( image );
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test
    void download (){
        byte[] get_image;
        try {
            //将读取到的图片存放到指定的路径中
            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\Shinelon\\Pictures\\Screenshots\\bb.jpg");
            Image image = new Image();
            image.setId( 3 );
            Example<Image> example = Example.of(image);
            Image image1 = imageRespository.findOne( example ).get();
            if (!image1.toString().isEmpty()) {
                get_image = image1.getContent();
            //将读取到的File对象转成字节流
               // InputStream inputStream = new FileInputStream( get_image );

                InputStream sbs = new ByteArrayInputStream(get_image);
                int a;
                byte b[] = new byte[2048];
                while ((a = sbs.read(b)) != -1) {
                    fileOutputStream.write(b, 0, a);
                }
                System.out.println("success");
            }
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            System.out.println("error2");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("error3");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error4");
        }
    }

}