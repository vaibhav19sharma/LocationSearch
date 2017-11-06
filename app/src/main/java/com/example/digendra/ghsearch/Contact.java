package com.example.digendra.ghsearch;


public class Contact {

    int id;
    String name;
    String mobileNO;
    String email;
    String password1;
    String password2;
    String UserName;
    String UserNo;

    public Contact() {
        // TODO Auto-generated constructor stub
    }
    public Contact(int id,String name,String mobileNO,String email,String password1,String password2,String UserName)
    {
        this.id=id;
        this.name=name;
        this.mobileNO=mobileNO;
        this.email=email;
        this.password1=password1;
        this.password2=password2;
        this.UserName=UserName;

    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword1() {
        return password1;
    }
    public void setPassword1(String password1) {
        this.password1 = password1;
    }
    public String getPassword2() {
        return password2;
    }
    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    public String getUserName() {
        return UserName;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }
    public String getUserNo() {
        return UserNo;
    }
    public void setUserNo(String userNo) {
        UserNo = userNo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getMobileNO() {
        return mobileNO;
    }
    public void setMobileNO(String mobileNO) {
        this.mobileNO = mobileNO;
    }


}


