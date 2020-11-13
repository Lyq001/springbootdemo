package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_workflowparammv;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_workflowparammvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
/*
 *工作流手动参数
 */
@RestController
@RequestMapping("/paramMV")
public class Autoetl_workflowparammvController {

    @Autowired
    private Autoetl_workflowparammvRepository autoetlWorkflowparammvRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_workflowparammv> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlWorkflowparammvRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_workflowparammv autoetl_workflowparammv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowparammv result = autoetlWorkflowparammvRepository.save( autoetl_workflowparammv );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_workflowparammv findById(@PathVariable("id") Integer id){
        Autoetl_workflowparammv autoetl_workflowparammv = autoetlWorkflowparammvRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_workflowparammv);
        return autoetl_workflowparammv;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_workflowparammv autoetl_workflowparammv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_workflowparammv result = autoetlWorkflowparammvRepository.save( autoetl_workflowparammv );
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
            autoetlWorkflowparammvRepository.deleteById( id );
        }
    }

}
