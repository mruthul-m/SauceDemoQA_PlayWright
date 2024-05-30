package com.playwright.saucedemo.utility;

import org.aeonbits.owner.Config;

@Config.Sources("file:src/test/resources/configurations/config.properties")
public interface TestConfig extends Config {

  @Key("URL")
  public String getUrl();

}
