package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_workflowsqlparam;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_workflowsqlparamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
/*
 *工作流sql参数
 */
@RestController
@RequestMapping("/paramSQL")
public class Autoetl_workflowsqlparamController {

    @Autowired
    private Autoetl_workflowsqlparamRepository autoetlWorkflowsqlparamRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_workflowsqlparam> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlWorkflowsqlparamRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_workflowsqlparam autoetl_workflowsqlparam){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowsqlparam result = autoetlWorkflowsqlparamRepository.save( autoetl_workflowsqlparam );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_workflowsqlparam findById(@PathVariable("id") Integer id){
        Autoetl_workflowsqlparam autoetl_workflowsqlparam = autoetlWorkflowsqlparamRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_workflowsqlparam);
        return autoetl_workflowsqlparam;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_workflowsqlparam autoetl_workflowsqlparam){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowsqlparam result = autoetlWorkflowsqlparamRepository.save( autoetl_workflowsqlparam );
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
            autoetlWorkflowsqlparamRepository.deleteById( id );
        }
    }

}
