package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodeforpro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodeforproid;
    private String discription;
    private Integer activitynodeid;
    private Integer procedureid;
}
