package com.lyq.springbootdemo.Controller.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Reportmodel_table;
import com.lyq.springbootdemo.Repository.DataSource.Reportmodel_tableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *表配置
 */
@RestController
@RequestMapping("/Table")
public class Reportmodel_tableController {

    @Autowired
    private Reportmodel_tableRepository reportmodelTableRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Reportmodel_table> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return reportmodelTableRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Reportmodel_table reportmodel_table){//利用RequestBody将前台传过来的json对象转为java对象
        Reportmodel_table result = reportmodelTableRepository.save( reportmodel_table );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Reportmodel_table findById(@PathVariable("id") Integer id){
        Reportmodel_table reportmodel_table = reportmodelTableRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+reportmodel_table);
        return reportmodel_table;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Reportmodel_table reportmodel_table){//利用RequestBody将前台传过来的json对象转为java对象
        Reportmodel_table result = reportmodelTableRepository.save( reportmodel_table );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    //通过工作流主键查询节点
    @GetMapping("/findByPId/{id}/{page}/{size}")
    public Page<Reportmodel_table> findByPId(@PathVariable("id") Integer id,
                                                @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        Reportmodel_table table = new Reportmodel_table();
        table.setDatasourceid( id );
        Example<Reportmodel_table> node = Example.of( table );
        return reportmodelTableRepository.findAll(node,pageable);
    }

    @DeleteMapping("/deleteById/{ids}")
    public void deleteById(@PathVariable("ids") int[] ids){
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            //System.out.println(id);
            reportmodelTableRepository.deleteById( id );
        }
    }
    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Reportmodel_table> findByNameLike(@PathVariable("name") String name){
        System.out.println(name);
        return reportmodelTableRepository.findByNameLike( name );
    }
}
