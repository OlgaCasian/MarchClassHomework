import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class GoogleSearchTest {

    private WebDriver driver;
    private String precedingXpath;

    @AfterSuite
    public void tearDown() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    /*
           -go to www.google.com page
           -in search input field type a string and submit search
           -verify that result page is showing up
           -verify that amount of results is more than 100
        */
    @Test
    public void test01(){
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");

        String inputAddress = "https://www.google.com/";
        String queryString = "Automation in Test";
        String cssSelectorValue = ".gLFyf";
        precedingXpath = "//*[@type='submit' and @value='Google Search']/preceding::*[@type='text']";

        //WebDriver driver;

        submitRequest(inputAddress, queryString, cssSelectorValue);
        analyseResults();
    }

    public void submitRequest(String inputAddress, String queryString, String cssSelectorValue) {
        driver = new FirefoxDriver();
        driver.get(inputAddress);
        //WebElement textInput = driver.findElement(By.cssSelector(cssSelectorValue)); todo: change this to XPath
        WebElement textInput = driver.findElement(By.xpath(precedingXpath));
        textInput.sendKeys(queryString);
        textInput.submit();

        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void analyseResults () {
        WebElement resultsStatsElement = driver.findElement(By.id("result-stats"));
        String resultsStatsText = resultsStatsElement.getText();
        String[] stringArray = resultsStatsText.split(" ");
        String amountOfResults = stringArray[1];
        String amountOfResultsFixed = amountOfResults.replace(",", "");
        int amountOfResultsParsed = Integer.parseInt(amountOfResultsFixed);
        Assert.assertTrue(amountOfResultsParsed > 100);
    }

}