package com.playwright.saucedemo.testcases;

import org.aeonbits.owner.ConfigFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.playwright.saucedemo.base.BrowserSetup;
import com.playwright.saucedemo.utility.TestConfig;

public class Hooks {

  private Browser browser;
  private BrowserSetup browserSetup;
  public Page page;

  public final TestConfig testconfig = ConfigFactory.create(TestConfig.class);

  @BeforeClass
  public void testSetup() {
    browserSetup = new BrowserSetup();
    browser = browserSetup.browserInit();
    page = browser.newPage();
    page.navigate(testconfig.getUrl());
  }

  @AfterClass
  public void tearDown() {
    browser.close();
  }

}
