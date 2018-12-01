package com.icss.entity;

import java.util.Date;

/***
 * 客户实体类
 */
public class Customer {
    private int id;
    private String phone;
    private String pwd;
    private String sex;
    private String realName;
    private Date birth;

    public Customer(String phone, String pwd, String imgurl) {
        this.phone = phone;
        this.pwd = pwd;
        this.imgurl = imgurl;
    }

    public Customer(String phone, String pwd, String imgurl, String sex, String realName, Date birth) {
        this.phone = phone;
        this.pwd = pwd;
        this.imgurl = imgurl;
        this.sex = sex;
        this.realName = realName;
        this.birth = birth;

    }

    public Customer(String phone, String pwd) {
        this.phone = phone;
        this.pwd = pwd;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    private String imgurl;

    public Customer(int id, String phone, String pwd, String imgurl, String sex, String realName, Date birthday) {
        this.id = id;
        this.phone = phone;
        this.pwd = pwd;
        this.imgurl=imgurl;
        this.sex = sex;
        this.realName = realName;
        this.birth = birth;
    }

    public Customer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", phone='" + phone + '\'' +
                ", pwd='" + pwd + '\'' +
                ", sex='" + sex + '\'' +
                ", realName='" + realName + '\'' +
                ", birthday=" + birth +
                '}';
    }
}
