package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodeforsql {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodeforsqlid;
    private String cacheline;
    private String datasourcesql;
    private String discription;
    private String activitynodeid;
    private Integer datasourceid;
    private Integer targettableid;
}
