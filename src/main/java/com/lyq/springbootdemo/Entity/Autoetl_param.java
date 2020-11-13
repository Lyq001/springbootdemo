package com.lyq.springbootdemo.Entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Autoetl_param {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paramid;
    private String fieldtype;
    private String paramname;
    private String discription;
}
