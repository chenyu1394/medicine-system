package com.wqg.system.service.admin.entity;


public class Agency {

  private String ano;
  private String aname;
  private String asex;
  private String aphone;
  private String aremark;
  private java.sql.Timestamp created;


  public String getAno() {
    return ano;
  }

  public void setAno(String ano) {
    this.ano = ano;
  }


  public String getAname() {
    return aname;
  }

  public void setAname(String aname) {
    this.aname = aname;
  }


  public String getAsex() {
    return asex;
  }

  public void setAsex(String asex) {
    this.asex = asex;
  }


  public String getAphone() {
    return aphone;
  }

  public void setAphone(String aphone) {
    this.aphone = aphone;
  }


  public String getAremark() {
    return aremark;
  }

  public void setAremark(String aremark) {
    this.aremark = aremark;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }

}
