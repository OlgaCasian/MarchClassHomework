import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import static java.lang.Thread.sleep;

public class DiceUpdateProfile {
    private WebDriver driver;
    private WebDriverWait driverWait;
    private String email = "test";
    private String pass = "test";



    @BeforeSuite
    public void testSuiteSetup() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
    }
    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
    /*
    //Go to www.dice.com
    //Locate Login element and click on it
    //On login page enter email and password, click submit
    //At the right side of page click "Profile"
    //Scroll down, under "Skills" click on "Add a skill" button
    //Enter the skill and year and click "Add" button
    //Click "Save" button
    */
    //todo implement delete last skill

    @Test
    public void test01() throws InterruptedException {
        String inputAddress = "https://www.dice.com/";
        String loginSelector = "navbarDropdown-10";
        String loginXPath = "//*[text()='\n" + "Login    ']";
        String emailId = "email";
        String passId = "password";
        String submit = "//button[@type='submit']";
        String profile = "//h2[@class='row-title' and text()='Profile']";
        String addSkill = "addSkillBtn";
        String newSkillId = "newSkillName";
        //todo make sure skill length <= accepted skill.length on dice
        String newSkill = "Selenium Web Driver IntelliJ IDEA automation tester";
        String newSkillExperience = "newSkillYearsExp";
        String newSkillYears = "4";
        String submitSkill = "//button[@type='submit' and @class='btn btn-default addNewSkillButton']";
        String saveChanges = "//button[text()='Save' and @data-ng-click=\"assignAnnualAndHourlySalary(); toggleEditMode('off', $event); saveProfile({ isForceNoDelay: true });\"]";


        driver.get(inputAddress);
        waitForElements();
        driver.findElement(By.id(loginSelector)).click();
        driver.findElement(By.xpath(loginXPath)).click();
        waitForElements();
        driver.findElement(By.id(emailId)).sendKeys(email);
        driver.findElement(By.id(passId)).sendKeys(pass);
        driver.findElement(By.xpath(submit)).click();
        waitForElements();
        driver.findElement(By.xpath(profile)).click();
        waitForElements();
        driver.findElement(By.id(addSkill)).click();
        driver.findElement(By.id(newSkillId)).sendKeys(newSkill);
        driver.findElement(By.id(newSkillExperience)).sendKeys(newSkillYears);
        waitForElements();
        driver.findElement(By.xpath(submitSkill)).click();
        waitForElements();
        driver.findElement(By.xpath(saveChanges)).click();
    }

    private void waitForElements() {
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //driverWait.until(ExpectedConditions.elementToBeClickable(By.id(loginSelector)));
    }
}