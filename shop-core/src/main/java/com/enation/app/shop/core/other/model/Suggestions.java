package com.enation.app.shop.core.other.model;

import com.enation.framework.database.PrimaryKeyField;

public class Suggestions {

  private long id;
  private long create_date;
  private String suggest_name;
  private String suggest_tel;
  private String title;
  private String content;

  // 主键
  @PrimaryKeyField
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getCreate_date() {
    return create_date;
  }

  public void setCreate_date(long create_date) {
    this.create_date = create_date;
  }

  public String getSuggest_name() {
    return suggest_name;
  }

  public void setSuggest_name(String suggest_name) {
    this.suggest_name = suggest_name;
  }

  public String getSuggest_tel() {
    return suggest_tel;
  }

  public void setSuggest_tel(String suggest_tel) {
    this.suggest_tel = suggest_tel;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
