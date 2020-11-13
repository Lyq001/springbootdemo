package com.lyq.springbootdemo.Entity.AutoEtl;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_workflow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer autoworkflowid;
    private Integer endtime;
    private Integer errorwaittime;
    private Integer procesewaittime;
    private Integer starttime;
    private String strdiscription;
    private String streffectivetype;
    private String strparamvaluetype;
    private String strworkflowname;
}
