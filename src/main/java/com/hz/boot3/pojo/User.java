package com.hz.boot3.pojo;

import lombok.Data;

@Data
public class User {
	private Integer id; //id 
	private String userCode; //用户编码
	private String userName; //用户名称
	private String userPassword; //用户密码
	private Integer gender;  //性别
	private String birthday;  //出生日期
	private String phone;   //电话
	private String address; //地址
	private Integer userRole;    //用户角色
	private Integer createdBy;   //创建者
	private String creationDate; //创建时间
	private Integer modifyBy;     //更新者
	private String modifyDate;   //更新时间
	private Role role; //角色

}
