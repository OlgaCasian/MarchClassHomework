import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class XpathTest {

    private WebDriver driver;

    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/login");
        String fullXpath = "/html/body/div[2]/div/div/form/button";
        String relativeXpath = "//form/button";
        String xpath = "//*[@id='login']/button";
        String oneAttributeXpath = "//button[@class='radius']";
        String twoAttributeXpath = "//button[@class='radius'][@type='submit']";
        String orAttributeXpath = "//button[@class='radius' or @type='submit']";
        String andAttributeXpath = "//button[@class='radius' and @type='submit']";
        String containsXpath = "//button[contains(@class,'adiu')]";
        String startsWithXpath = "//button[starts-with(@class,'rad')]";
        String textXpath = "//*[text()=' Login']";
        String lastXpath = "(//a)[last()]";
        String followingXpath = "//*[@name='username']/following::*[@type='password']";
        String precedingXpath = "//*[@name='password']/preceding::*[@type='text']";
    }
}
