package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_activitynodeprocp;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_activitynodeprocpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
/*
*节点启动参数
 */
@RestController
@RequestMapping("/NodeParamProcP")
public class Autoetl_activitynodeprocpController {
    @Autowired
    private Autoetl_activitynodeprocpRepository autoetl_activitynodeprocpRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_activitynodeprocp> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetl_activitynodeprocpRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_activitynodeprocp autoetl_activitynodeprocp){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodeprocp result = autoetl_activitynodeprocpRepository.save( autoetl_activitynodeprocp );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_activitynodeprocp findById(@PathVariable("id") Integer id){
        Autoetl_activitynodeprocp autoetl_activitynodeprocp = autoetl_activitynodeprocpRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_activitynodeprocp);
        return autoetl_activitynodeprocp;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_activitynodeprocp autoetl_activitynodeprocp){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodeprocp result = autoetl_activitynodeprocpRepository.save( autoetl_activitynodeprocp );
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
            autoetl_activitynodeprocpRepository.deleteById( id );
        }
    }
}
