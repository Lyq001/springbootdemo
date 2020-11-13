package com.lyq.springbootdemo.Repository.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Reportmodel_field;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Reportmodel_fieldRepository extends JpaRepository<Reportmodel_field,Integer> {
    @Query(value = "select t from Reportmodel_field t where t.fieldname like %?1%")
    List<Reportmodel_field> findByNameLike(String name);
}
