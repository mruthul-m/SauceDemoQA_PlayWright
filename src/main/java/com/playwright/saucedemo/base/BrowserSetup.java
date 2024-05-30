package com.playwright.saucedemo.base;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public final class BrowserSetup {

  private Playwright playwright;
  private Browser browser;

  public BrowserSetup() {
    this.playwright = Playwright.create();
  }

  public Browser browserInit() {
    if (browser == null)
      browser = playwright.chromium()
          .launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

    return browser;


  }
}
