package com.lyq.springbootdemo.Entity.DataSource;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_procedure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer procedureid;
    private String discription;
    private String procedurename;
    private String proceduretype;
    private Integer datasourceid;
}
