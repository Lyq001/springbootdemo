package com.lyq.springbootdemo.Repository.AutoEtl;

import com.lyq.springbootdemo.Entity.AutoEtl.Autoetl_activitynode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Autoetl_activitynodeRepository extends JpaRepository<Autoetl_activitynode,Integer> {
    @Query(value = "select t from Autoetl_activitynode t where t.activitynodename like %?1%")
    List<Autoetl_activitynode> findByNameLike(String name);
}
