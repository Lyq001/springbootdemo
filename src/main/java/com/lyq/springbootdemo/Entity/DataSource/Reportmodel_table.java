package com.lyq.springbootdemo.Entity.DataSource;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Reportmodel_table {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tableid;
    private String addfields;
    private String autodto;
    private String checkinstance;
    private String chinaname;
    private String discription;
    private String tablename;
    private Integer datasourceid;
    private String suit;
}
