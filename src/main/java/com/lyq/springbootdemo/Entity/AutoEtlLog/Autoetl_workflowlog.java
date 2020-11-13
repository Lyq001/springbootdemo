package com.lyq.springbootdemo.Entity.AutoEtlLog;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Autoetl_workflowlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer workflowlogid;
    private Date dtdate;
    private String content;
    private String discription;
    private String operationtype;
    private String param;
    private String resulttype;
    private String username;
    private Integer datasourceid;
}
