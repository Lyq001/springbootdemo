package com.lyq.springbootdemo.Repository.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Autoetl_datasource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Autoetl_datasourceRepository extends JpaRepository<Autoetl_datasource,Integer> {
    @Query(value = "select t from Autoetl_datasource t where t.sessionfactory like %?1%")
    List<Autoetl_datasource> findByNameLike(String name);
}
