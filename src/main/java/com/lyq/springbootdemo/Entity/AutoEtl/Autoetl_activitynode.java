package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodeid;
    private Integer intorder;
    private String activitynodename;
    private String activitynodetype;
    private String discription;
    private String intordergroup;
    private String repeattype;
    private String sqlcondition;
    private String startconditiontype;
    private Integer datasourceid;
    private Integer procedureid;
    private Integer workflowid;
}
