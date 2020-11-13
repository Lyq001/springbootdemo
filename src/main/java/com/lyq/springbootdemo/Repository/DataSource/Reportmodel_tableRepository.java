package com.lyq.springbootdemo.Repository.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Reportmodel_table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Reportmodel_tableRepository extends JpaRepository<Reportmodel_table,Integer> {
    @Query(value = "select t from Reportmodel_table t where t.tablename like %?1%")
    List<Reportmodel_table> findByNameLike(String name);
}
