package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodeforct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodeforctid;
    private String cacheline;
    private Integer activitynodeid;
    private Integer tableid;
    private Integer targettableid;
}
