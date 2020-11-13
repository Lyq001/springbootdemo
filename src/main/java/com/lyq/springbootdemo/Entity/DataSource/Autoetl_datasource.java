package com.lyq.springbootdemo.Entity.DataSource;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_datasource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer datasourceid;
    private String sessionfactory;
    private String databasetype;
    private String discription;
    private String driver;
    private String dburl;
    private String dbuser;
    private String dbpassword;
}
