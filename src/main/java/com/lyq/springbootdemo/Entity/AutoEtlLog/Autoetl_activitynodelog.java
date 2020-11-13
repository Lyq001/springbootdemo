package com.lyq.springbootdemo.Entity.AutoEtlLog;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_activitynodelog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer activitynodelogid;
    private Integer intorder;
    private String activitynodeexcutetype;
    private String content;
    private String discription;
    private String strlines;
    private String param;
    private String resulttype;
    private Integer activitynodeid;
    private Integer etlworkflowlogid;
}
