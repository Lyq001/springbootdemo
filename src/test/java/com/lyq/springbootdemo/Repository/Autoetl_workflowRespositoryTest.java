package com.lyq.springbootdemo.Repository;

import com.lyq.springbootdemo.Repository.AutoEtl.Autoetl_workflowRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Autoetl_workflowRespositoryTest {

    @Autowired
    private Autoetl_workflowRepository autoetl_workflowRespository;

    @Test
    void deleteById(){
        Integer[] ids = new Integer[2];;
        ids[0]=1;
        ids[1]=2;
        for (int i = 0; i < ids.length; i++) {
            int id = ids[i];
            System.out.println(id);
            //autoetl_workflowRespository.deleteById( id );
        }
    }

}