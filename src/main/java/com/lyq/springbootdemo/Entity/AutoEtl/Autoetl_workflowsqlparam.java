package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_workflowsqlparam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sqlparamid;
    private String datasourcesql;
    private Integer datasourceid;
    private Integer workflowid;
}
