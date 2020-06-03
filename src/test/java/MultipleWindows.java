import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import java.util.Set;

import static java.lang.Thread.sleep;

public class MultipleWindows {

    private static final String WINDOWS_MAIN_PAGE = "https://the-internet.herokuapp.com/windows";
    WebDriver driver;
    private String originalWindowHandle;
    private String newWindowHandle;

    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @AfterSuite
    public void tearDown() {
        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.quit();
    }

    //1. Open the browser
    //2. Go to "https://the-internet.herokuapp.com/windows" page
    //3. Click on "Click Here" link
    //4. Verify that the amount of windows is "2"
    //5. Verify new window title
    //6. Verify new window text
    //7. Switch back to original window
    //8. Verify original window title
    @Test
    public void test01() {
        String expectedNewWindowTitle = "New Window";
        String expectedNewWindowText = "New Window";
        String expectedOriginalWindowTitle = "The Internet";
        int expectedAmountOfWindows = 2;

        openThePage();
        clickOnLink();
        verifyAmountOfWindows(expectedAmountOfWindows);
        switchToNewWindow();
        verifyWindowTitle(expectedNewWindowTitle);
        verifyWindowText(expectedNewWindowText);
        switchToOriginalWindow();
        verifyWindowTitle(expectedOriginalWindowTitle);
    }
    //TODO: different scenario
    //1. Open the browser
    //2. Go to "https://the-internet.herokuapp.com/windows" page
    //3. Verify that heading has the text: "Opening a new window"
    //4. Verify that link with text: "Click Here" is clickable
    //5. Click on the link 3 times
    //6. Verify that there were created 3 new windows (4 in total)

    @Test
    public void test02() {
        String expectedHeadingText = "Opening a new window";
        String SelectorValue = "h3";

        openThePage();
        verifyHeading(SelectorValue, expectedHeadingText);
        verifyLinkIsClickable();
        clickOnLink();
        clickOnLink();
        clickOnLink();
        verifyAmountOfWindows(4);

    }

    private void verifyLinkIsClickable() {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"content\"]/div/a")));
        //do we need an assert here? Assert.assertTrue(element.isEnabled());
        //wait.until(ExpectedConditions.attributeToBeNotEmpty(webElement));
        WebElement webElement = driver.findElement(new By.ByXPath("//*[@id=\"content\"]/div/a"));
        String attributeWebElement = webElement.getAttribute("href");
        Assert.assertTrue(attributeWebElement != null);

    }

    private void verifyHeading(String heading, String headingText) {
        By expectedElement = By.tagName(heading);
        String actualHeadingText = waitForElement(expectedElement).getText();
        Assert.assertEquals(actualHeadingText, headingText);
    }

    private void switchToNewWindow() {
        driver.switchTo().window(newWindowHandle);
    }

    private void switchToOriginalWindow() {
        driver.switchTo().window(originalWindowHandle);
    }

    private void verifyWindowText(String expectedText) {
        Assert.assertTrue(driver.getPageSource().contains(expectedText));
    }

    private void verifyWindowTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    //TODO: change from sleep to wait
    private void verifyAmountOfWindows(int expectedAmount) {
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //WebDriverWait newWait = new WebDriverWait(driver, 5);
        //newWait.until(ExpectedConditions.titleContains("The Internet")); //todo: expected [New Window] but found []

        //driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);


        Set<String> windowHandles = driver.getWindowHandles();
        int actualAmountOfHandles = windowHandles.size();
        Assert.assertEquals(actualAmountOfHandles, expectedAmount);
        originalWindowHandle = (String) windowHandles.toArray()[0];
        newWindowHandle = (String) windowHandles.toArray()[1];
    }

    private void openThePage() {
        driver.get(WINDOWS_MAIN_PAGE);
    }

    //TODO: change to class attribute
    private void clickOnLink() {
        clickLink newClick = new clickLink();
        By expectedElement = By.linkText(newClick.clickText);
        waitForElement(expectedElement).click();
    }

    private WebElement waitForElement(By expectedElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        WebElement foundedElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(expectedElement));
        return foundedElement;
    }
}
