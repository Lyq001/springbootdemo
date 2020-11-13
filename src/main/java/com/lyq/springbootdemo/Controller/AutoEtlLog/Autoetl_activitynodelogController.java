package com.lyq.springbootdemo.Controller.AutoEtlLog;

import com.lyq.springbootdemo.Entity.AutoEtlLog.Autoetl_activitynodelog;
import com.lyq.springbootdemo.Repository.AutoEtlLog.Autoetl_activitynodelogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

/*
 *节点日志
 */
@RestController
@RequestMapping("/AcNodeLog")
public class Autoetl_activitynodelogController {
    @Autowired
    private Autoetl_activitynodelogRepository autoetlActivitynodelogRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_activitynodelog> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlActivitynodelogRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_activitynodelog autoetl_activitynodelog){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodelog result = autoetlActivitynodelogRepository.save( autoetl_activitynodelog );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_activitynodelog findById(@PathVariable("id") Integer id){
        Autoetl_activitynodelog autoetl_activitynodelog = autoetlActivitynodelogRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_activitynodelog);
        return autoetl_activitynodelog;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_activitynodelog autoetl_activitynodelog){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynodelog result = autoetlActivitynodelogRepository.save( autoetl_activitynodelog );
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
            autoetlActivitynodelogRepository.deleteById( id );
        }
    }
}
