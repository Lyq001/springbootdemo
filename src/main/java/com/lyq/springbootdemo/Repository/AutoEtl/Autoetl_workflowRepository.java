package com.lyq.springbootdemo.Repository.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_workflow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Autoetl_workflowRepository extends JpaRepository<Autoetl_workflow,Integer> {

    @Query(value = "select t from Autoetl_workflow t where t.strworkflowname like %?1%")
    List<Autoetl_workflow> findByNameLike(String name);
}
