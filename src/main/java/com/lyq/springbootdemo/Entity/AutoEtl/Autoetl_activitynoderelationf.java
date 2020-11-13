package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynoderelationf {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynoderelationfid;
    private Integer intorder;
    private String conditionjointype;
    private String conditiontype;
    private String strvalue;
    private Integer activitynodeforctid;
    private Integer relationfieldid;
}
