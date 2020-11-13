package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_workflow;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_workflowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *工作流
 */
@RestController
@RequestMapping("/AutoETL")
public class Autoetl_workflowController {

    @Autowired
    private Autoetl_workflowRepository autoetl_workflowRespository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_workflow> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetl_workflowRespository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_workflow autoetl_workflow){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflow result = autoetl_workflowRespository.save( autoetl_workflow );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_workflow findById(@PathVariable("id") Integer id){
        Autoetl_workflow autoetl_workflow = autoetl_workflowRespository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_workflow);
        return autoetl_workflow;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_workflow autoetl_workflow){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflow result = autoetl_workflowRespository.save( autoetl_workflow );
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
            autoetl_workflowRespository.deleteById( id );
        }
    }

    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Autoetl_workflow> findByNameLike(@PathVariable("name") String name){
        return autoetl_workflowRespository.findByNameLike( name );
    }

}
