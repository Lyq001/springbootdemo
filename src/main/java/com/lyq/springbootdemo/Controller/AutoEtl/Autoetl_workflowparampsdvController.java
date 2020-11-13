package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_workflowparampsdv;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_workflowparampsdvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
/*
 *工作流自动参数
 */
@RestController
@RequestMapping("/paramPSDV")
public class Autoetl_workflowparampsdvController {

    @Autowired
    private Autoetl_workflowparampsdvRepository autoetlWorkflowparampsdvRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_workflowparampsdv> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlWorkflowparampsdvRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_workflowparampsdv autoetl_workflowparampsdv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowparampsdv result = autoetlWorkflowparampsdvRepository.save( autoetl_workflowparampsdv );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_workflowparampsdv findById(@PathVariable("id") Integer id){
        Autoetl_workflowparampsdv autoetl_workflowparampsdv = autoetlWorkflowparampsdvRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_workflowparampsdv);
        return autoetl_workflowparampsdv;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_workflowparampsdv autoetl_workflowparampsdv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowparampsdv result = autoetlWorkflowparampsdvRepository.save( autoetl_workflowparampsdv );
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
            autoetlWorkflowparampsdvRepository.deleteById( id );
        }
    }

}
