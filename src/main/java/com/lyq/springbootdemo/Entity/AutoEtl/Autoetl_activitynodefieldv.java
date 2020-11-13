package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodefieldv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodefieldvid;
    private String strvalue;
    private Integer activitynodeforctid;;
    private Integer relationfieldid;
    private Integer fieldid;
}
