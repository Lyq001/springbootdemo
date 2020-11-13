package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_activitynodeforsql;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_activitynodeforsqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/*
 *sql数据传输节点
 */
@RestController
@RequestMapping("/AcNodeSql")
public class Autoetl_activitynodeforsqlController {
    @Autowired
    private Autoetl_activitynodeforsqlRepository autoetlActivitynodeforsqlRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_activitynodeforsql> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlActivitynodeforsqlRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_activitynodeforsql autoetl_activitynodeforsql){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodeforsql result = autoetlActivitynodeforsqlRepository.save( autoetl_activitynodeforsql );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_activitynodeforsql findById(@PathVariable("id") Integer id){
        Autoetl_activitynodeforsql autoetl_activitynodeforsql = autoetlActivitynodeforsqlRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_activitynodeforsql);
        return autoetl_activitynodeforsql;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_activitynodeforsql autoetl_activitynodeforsql){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodeforsql result = autoetlActivitynodeforsqlRepository.save( autoetl_activitynodeforsql );
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
            autoetlActivitynodeforsqlRepository.deleteById( id );
        }
    }
}
