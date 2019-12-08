package com.wqg.system.service.admin.entity;


public class Medicine {

  private String mno;
  private String mname;
  private String mmode;
  private String mefficacy;
  private java.sql.Timestamp created;
  private String cno;


  public String getMno() {
    return mno;
  }

  public void setMno(String mno) {
    this.mno = mno;
  }


  public String getMname() {
    return mname;
  }

  public void setMname(String mname) {
    this.mname = mname;
  }


  public String getMmode() {
    return mmode;
  }

  public void setMmode(String mmode) {
    this.mmode = mmode;
  }


  public String getMefficacy() {
    return mefficacy;
  }

  public void setMefficacy(String mefficacy) {
    this.mefficacy = mefficacy;
  }


  public java.sql.Timestamp getCreated() {
    return created;
  }

  public void setCreated(java.sql.Timestamp created) {
    this.created = created;
  }


  public String getCno() {
    return cno;
  }

  public void setCno(String cno) {
    this.cno = cno;
  }

}
