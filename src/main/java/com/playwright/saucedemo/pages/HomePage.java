package com.playwright.saucedemo.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {

  private final Page page;
  public final Locator username;
  public final Locator password;
  public final Locator login;

  public HomePage(Page page) {
    this.page = page;
    this.username = page.locator("#user-name");
    this.password = page.getByPlaceholder("Password");
    this.login = page.locator("[type='submit']");
  }

  public HomePage setUserName(String username) {
    this.username.fill(username);
    return this;
  }

  public HomePage setPassword(String password) {
    this.password.fill(password);
    return this;
  }

  public HomePage clickLoginBtn() {
    this.login.click();
    return this;
  }

  public void navigateTo(String url) {
    page.navigate(url);
  }

}
