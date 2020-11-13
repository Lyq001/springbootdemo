package com.lyq.springbootdemo.Repository.AutoEtlLog;

import com.lyq.springbootdemo.Entity.AutoEtlLog.Autoetl_workflowlog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Autoetl_workflowlogRepository extends JpaRepository<Autoetl_workflowlog,Integer> {
}
