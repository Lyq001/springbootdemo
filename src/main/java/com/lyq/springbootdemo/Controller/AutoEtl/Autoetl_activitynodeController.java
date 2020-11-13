package com.lyq.springbootdemo.Controller.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_activitynode;
import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_activitynodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *节点
 */
@RestController
@RequestMapping("/AcNode")
public class Autoetl_activitynodeController {
    @Autowired
    private Autoetl_activitynodeRepository autoetl_activitynodeRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_activitynode> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetl_activitynodeRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_activitynode autoetl_activitynode){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynode result = autoetl_activitynodeRepository.save( autoetl_activitynode );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_activitynode findById(@PathVariable("id") Integer id){
        Autoetl_activitynode autoetl_activitynode = autoetl_activitynodeRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_activitynode);
        return autoetl_activitynode;
    }
    //通过工作流主键查询节点
    @GetMapping("/findByPId/{id}/{page}/{size}")
    public Page<Autoetl_activitynode> findByPId(@PathVariable("id") Integer id,
           @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        Autoetl_activitynode activitynode = new Autoetl_activitynode();
        activitynode.setWorkflowid( id );
        Example<Autoetl_activitynode> node = Example.of( activitynode );
        return autoetl_activitynodeRepository.findAll(node,pageable);
    }
    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_activitynode autoetl_activitynode){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_activitynode result = autoetl_activitynodeRepository.save( autoetl_activitynode );
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
            autoetl_activitynodeRepository.deleteById( id );
        }
    }

    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Autoetl_activitynode> findByNameLike(@PathVariable("name") String name){
        System.out.println(name);
        return autoetl_activitynodeRepository.findByNameLike( name );
    }
}
