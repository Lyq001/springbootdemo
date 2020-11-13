package com.lyq.springbootdemo.Entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//设置主键自增
    private Integer id;
    private String file_name;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column(columnDefinition="longblob", nullable=true)
    private byte[] content;
    private String group_01;
    private String group_02;
    private String group_03;

}
