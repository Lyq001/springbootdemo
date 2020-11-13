package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_activitynodefieldv;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_activitynodefieldvRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/*
 *表节点字段映射
 */
@RestController
@RequestMapping("/AcNodeCTFieldV")
public class Autoetl_activitynodefieldvController {
    @Autowired
    private Autoetl_activitynodefieldvRepository autoetlActivitynodefieldvRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_activitynodefieldv> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlActivitynodefieldvRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_activitynodefieldv autoetl_activitynodefieldv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodefieldv result = autoetlActivitynodefieldvRepository.save( autoetl_activitynodefieldv );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_activitynodefieldv findById(@PathVariable("id") Integer id){
        Autoetl_activitynodefieldv autoetl_activitynodefieldv = autoetlActivitynodefieldvRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_activitynodefieldv);
        return autoetl_activitynodefieldv;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_activitynodefieldv autoetl_activitynodefieldv){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodefieldv result = autoetlActivitynodefieldvRepository.save( autoetl_activitynodefieldv );
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
            autoetlActivitynodefieldvRepository.deleteById( id );
        }
    }
}
