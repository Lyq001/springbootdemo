package com.lyq.springbootdemo.Entity.DataSource;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Reportmodel_field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fieldid;
    private String iskey;
    private String isenable;
    private Integer nlength;
    private Integer nprecise;
    private Integer nseq;
    private String chinaname;
    private String constlist;
    private String dbconstlist;
    private String discription;
    private String emptytype;
    private String fieldname;
    private String fieldtype;
    private String logicemptytype;
    private Integer tableid;
}
