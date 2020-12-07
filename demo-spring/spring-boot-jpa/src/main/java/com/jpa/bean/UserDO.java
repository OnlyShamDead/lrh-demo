package com.jpa.bean;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tting_org_user")
@Data
public class UserDO {

    @Id   // 表明id
    @GeneratedValue   //  自动生成
    private int mainId;

    private String openId;

    private String name;

    private int sex;

    private String city;

    private String country;

    private String headimgUrl;

    private String longitude;

    private String latitude;

    private int isFollow;



}
