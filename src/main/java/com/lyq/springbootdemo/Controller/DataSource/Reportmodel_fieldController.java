package com.lyq.springbootdemo.Controller.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Reportmodel_field;
import com.lyq.springbootdemo.Repository.DataSource.Reportmodel_fieldRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *表字段配置
 */
@RestController
@RequestMapping("/Field")
public class Reportmodel_fieldController {

    @Autowired
    private Reportmodel_fieldRepository reportmodelFieldRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Reportmodel_field> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return reportmodelFieldRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Reportmodel_field reportmodel_field){//利用RequestBody将前台传过来的json对象转为java对象
        Reportmodel_field result = reportmodelFieldRepository.save( reportmodel_field );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Reportmodel_field findById(@PathVariable("id") Integer id){
        Reportmodel_field reportmodel_field = reportmodelFieldRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+reportmodel_field);
        return reportmodel_field;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Reportmodel_field reportmodel_field){//利用RequestBody将前台传过来的json对象转为java对象
        Reportmodel_field result = reportmodelFieldRepository.save( reportmodel_field );
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
            reportmodelFieldRepository.deleteById( id );
        }
    }

    //通过工作流主键查询节点
    @GetMapping("/findByPId/{id}/{page}/{size}")
    public Page<Reportmodel_field> findByPId(@PathVariable("id") Integer id,
                                             @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        Reportmodel_field field = new Reportmodel_field();
        field.setTableid( id );
        Example<Reportmodel_field> node = Example.of( field );
        return reportmodelFieldRepository.findAll(node,pageable);
    }
    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Reportmodel_field> findByNameLike(@PathVariable("name") String name){
        System.out.println(name);
        return reportmodelFieldRepository.findByNameLike( name );
    }
}
