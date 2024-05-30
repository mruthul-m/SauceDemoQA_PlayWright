package com.playwright.saucedemo.testcases;

import static org.testng.Assert.assertEquals;
import java.util.HashMap;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.playwright.saucedemo.pages.HomePage;
import com.playwright.saucedemo.utils.DataProviders;

public class ValidLoginTest extends Hooks {

  HomePage homePage;

  @BeforeMethod
  public void homePageReload() {
    page.navigate(testconfig.getUrl());
  }

  @Test(dataProvider = "getData", dataProviderClass = DataProviders.class)
  public void passingValidCredentials(HashMap<String, String> input) {
    homePage = new HomePage(page);
    homePage.setUserName(input.get("username")).setPassword(input.get("password")).clickLoginBtn();
    assertEquals(page.url(), "https://www.saucedemo.com/inventory.html");

  }


}
