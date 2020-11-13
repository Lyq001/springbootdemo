package com.lyq.springbootdemo.Controller.AutoEtlLog;

import com.lyq.springbootdemo.Entity.AutoEtlLog.Autoetl_workflowlog;
import com.lyq.springbootdemo.Repository.AutoEtlLog.Autoetl_workflowlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/*
 *工作流日志
 */
@RestController
@RequestMapping("/WorkFlowLog")
public class Autoetl_workflowlogController {

    @Autowired
    private Autoetl_workflowlogRepository autoetlWorkflowlogRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_workflowlog> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlWorkflowlogRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_workflowlog autoetl_workflowlog){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowlog result = autoetlWorkflowlogRepository.save( autoetl_workflowlog );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_workflowlog findById(@PathVariable("id") Integer id){
        Autoetl_workflowlog autoetl_workflowlog = autoetlWorkflowlogRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_workflowlog);
        return autoetl_workflowlog;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_workflowlog autoetl_workflowlog){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowlog result = autoetlWorkflowlogRepository.save( autoetl_workflowlog );
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
            autoetlWorkflowlogRepository.deleteById( id );
        }
    }

}
