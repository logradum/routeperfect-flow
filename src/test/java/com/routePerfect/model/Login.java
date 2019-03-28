package com.routePerfect.model;

public class Login {
  private String email;
  private String name;
  private String password;

  public Login(String email, String name, String password) {
    this.email = email;
    this.name = name;
    this.password = password;
  }
  public Login() {
    this.email = email;
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public String getName() {
    return name;
  }

  public String getPassword() {
    return password;
  }

  public Login setEmail(String email) {
    this.email = email;
    return this;
  }

  public Login setName(String name) {
    this.name = name;
    return this;
  }

  public Login setPassword(String password) {
    this.password = password;
    return this;
  }
}
