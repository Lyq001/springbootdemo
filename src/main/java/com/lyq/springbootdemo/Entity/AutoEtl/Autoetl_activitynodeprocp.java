package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodeprocp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodeprocpid;
    private String paramidlist;
    private Integer activitynodeid;
    private Integer paramid;
}
