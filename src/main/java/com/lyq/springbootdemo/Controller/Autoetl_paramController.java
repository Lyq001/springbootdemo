package com.lyq.springbootdemo.Controller;

import com.lyq.springbootdemo.Entity.Autoetl_param;
import com.lyq.springbootdemo.Repository.Autoetl_paramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/*
 *系统参数配置
 */
@RestController
@RequestMapping("/Param")
public class Autoetl_paramController {

    @Autowired
    private Autoetl_paramRepository autoetlParamRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_param> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlParamRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_param autoetl_param){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_param result = autoetlParamRepository.save( autoetl_param );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_param findById(@PathVariable("id") Integer id){
        Autoetl_param autoetl_param = autoetlParamRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_param);
        return autoetl_param;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_param autoetl_param){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_param result = autoetlParamRepository.save( autoetl_param );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{ids}")
    public void deleteById(@PathVariable("ids") int[] ids){
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            //System.out.println(id);
            autoetlParamRepository.deleteById( id );
        }
    }

}
