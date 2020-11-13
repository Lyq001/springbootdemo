package com.lyq.springbootdemo.Controller.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Autoetl_procedure;
import com.lyq.springbootdemo.Repository.DataSource.Autoetl_procedureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 *存储过程配置
 */
@RestController
@RequestMapping("/Procedure")
public class Autoetl_procedureController {

    @Autowired
    private Autoetl_procedureRepository autoetlProcedureRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Autoetl_procedure> findAll(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        return autoetlProcedureRepository.findAll(pageable);
    }

    @PostMapping("/save")
    public String save(@RequestBody Autoetl_procedure autoetl_procedure){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_procedure result = autoetlProcedureRepository.save( autoetl_procedure );
        if(result != null){
            return "success";
        }else{
            return "error";
        }
    }
    @GetMapping("/findById/{id}")
    public Autoetl_procedure findById(@PathVariable("id") Integer id){
        Autoetl_procedure autoetl_procedure = autoetlProcedureRepository.findById( id ).get();//在java8中提供Optional<T>类解决空值问题，需要get()方法获取被包装的对象。
        System.out.println("liuyaqi:"+autoetl_procedure);
        return autoetl_procedure;
    }

    @PutMapping("/update")//于保存方法一致，由于请求方式差别需要单独封装一个update方法
    public String update(@RequestBody Autoetl_procedure autoetl_procedure){//利用RequestBody将前台传过来的json对象转为java对象
        Autoetl_procedure result = autoetlProcedureRepository.save( autoetl_procedure );
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
            autoetlProcedureRepository.deleteById( id );
        }
    }

    //通过工作流主键查询节点
    @GetMapping("/findByPId/{id}/{page}/{size}")
    public Page<Autoetl_procedure> findByPId(@PathVariable("id") Integer id,
                                             @PathVariable("page") Integer page, @PathVariable("size") Integer size){
        PageRequest pageable = PageRequest.of(page-1,size);
        Autoetl_procedure procedure = new Autoetl_procedure();
        procedure.setDatasourceid( id );
        Example<Autoetl_procedure> node = Example.of( procedure );
        return autoetlProcedureRepository.findAll(node,pageable);
    }
    //搜索框模糊查询
    @GetMapping("/findByNameLike/{name}")
    public List<Autoetl_procedure> findByNameLike(@PathVariable("name") String name){
        System.out.println(name);
        return autoetlProcedureRepository.findByNameLike( name );
    }

}
