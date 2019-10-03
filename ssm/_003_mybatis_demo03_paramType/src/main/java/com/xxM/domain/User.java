package com.xxM.domain;

import lombok.Data;

import java.util.Date;
@Data
public class User {
    private Integer id;  /*int(11)*/
    private String username;  /*varchar(32)*/
    private Date birthday;  /*datetime*/
    private String sex;  /*char(1)*/
    private String address;  /*varchar(256)*/

}
