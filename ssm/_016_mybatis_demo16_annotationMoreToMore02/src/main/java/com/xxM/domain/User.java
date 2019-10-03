package com.xxM.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class User {
    private Integer uid;  /*int(11)*/
    private String username;  /*varchar(32)*/
    private Date birthday;  /*datetime*/
    private String sex;  /*char(1)*/
    private String address;  /*varchar(256)*/
    private List<Account> accounts;
}
