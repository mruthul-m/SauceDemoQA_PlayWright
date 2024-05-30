package com.playwright.saucedemo.utility;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import com.playwright.saucedemo.utils.JsonDataConvertor;


public class DataProviders {

  @DataProvider
  public Object[] getData() throws IOException {
    List<HashMap<String, String>> data = JsonDataConvertor.getJsonData(
        System.getProperty("user.dir") + "/src/test/resources/testdata/validLoginCredentials.json");

    return data.toArray();
  }

}
