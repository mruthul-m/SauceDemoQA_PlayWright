package com.playwright.saucedemo.testcases;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.playwright.saucedemo.pages.HomePage;

public class ValidLoginTest extends Hooks {

  HomePage homePage;

  @BeforeMethod
  public void homePageReload() {
    page.navigate(testconfig.getUrl());
  }

  @DataProvider
  public Object[] getData() throws IOException {
    List<HashMap<String, String>> data = getJsonData(
        System.getProperty("user.dir") + "/src/test/resources/testdata/validLoginCredentials.json");

    return data.toArray();
  }

  @Test(dataProvider = "getData")
  public void passingValidCredentials(HashMap<String, String> input) {
    homePage = new HomePage(page);
    homePage.setUserName(input.get("username")).setPassword(input.get("password")).clickLoginBtn();
    assertEquals(page.url(), "https://www.saucedemo.com/inventory.html");

  }

  public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
    // conver json file content to json string
    String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
    ObjectMapper mapper = new ObjectMapper();
    List<HashMap<String, String>> data =
        mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});

    return data;
  }
}
