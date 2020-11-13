package com.lyq.springbootdemo.Repository.DataSource;

import com.lyq.springbootdemo.Entity.DataSource.Autoetl_procedure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Autoetl_procedureRepository extends JpaRepository<Autoetl_procedure,Integer> {

    @Query(value = "select t from Autoetl_procedure t where t.procedurename like %?1%")
    List<Autoetl_procedure> findByNameLike(String name);
}
