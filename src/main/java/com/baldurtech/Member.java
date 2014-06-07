package com.baldurtech;

public class Member
{
    Integer id = null;
    String username = null;
    String password = null;
    String sex = null;
    String email = null;
    String telephone = null;
    String address = null;
    
    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getId()
    {
        return id;
    }
    public void setUsername(String username)
    {
        this.username = username;
    }
    public String getUsername()
    {
        return username;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    public void setSex(String sex)
    {
        this.sex = sex;
    }
    public String getSex()
    {
        return sex;
    }
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }
    public String getTelephone()
    {
        return telephone;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }
    public String getAddress()
    {
        return address;
    }
}