package com.xxM.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class User implements Serializable {
    private Integer id;  /*int(11)*/
    private String username;  /*varchar(32)*/
    private Date birthday;  /*datetime*/
    private String sex;  /*char(1)*/
    private String address;  /*varchar(256)*/

}
