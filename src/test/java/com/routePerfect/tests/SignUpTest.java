package com.routePerfect.tests;
import org.testng.annotations.Test;


public class SignUpTest extends TestBase {
  @Test
  public void signUpTest(){
    fw.getLoginHelper().createUser("someEmail@gmail.com", "SomeName", "qwerty12345");
  }
}
