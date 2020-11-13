package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_workflowparammv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workflowparammvid;
    private Integer intgroup ;
    private String discription;
    private String strvalue;
    private Integer paramid;
    private Integer workflowid;
}
