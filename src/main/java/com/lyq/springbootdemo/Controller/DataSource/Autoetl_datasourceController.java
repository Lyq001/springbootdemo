package com.lyq.springbootdemo.Controller.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Autoetl_datasource;
import com.lyq.springbootdemo.Repository.DataSource.Autoetl_datasourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *数据库配置
 */
@RestController
@RequestMapping("/DataSource")
public class Autoetl_datasourceController {

    @Autowired
    private Autoetl_datasourceRepository autoetlDatasourceRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_datasource> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlDatasourceRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_datasource autoetl_datasource){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_datasource result = autoetlDatasourceRepository.save( autoetl_datasource );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_datasource findById(@PathVariable("id") Integer id){
        Autoetl_datasource autoetl_datasource = autoetlDatasourceRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_datasource);
        return autoetl_datasource;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_datasource autoetl_datasource){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_datasource result = autoetlDatasourceRepository.save( autoetl_datasource );
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
            autoetlDatasourceRepository.deleteById( id );
        }
    }
    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Autoetl_datasource> findByNameLike(@PathVariable("name") String name){
        System.out.println(name);
        return autoetlDatasourceRepository.findByNameLike( name );
    }
}
