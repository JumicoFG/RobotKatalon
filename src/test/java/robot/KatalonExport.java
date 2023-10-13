package robot;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class KatalonExport {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\dfrgr\\Downloads\\Formation\\geckodriver.exe");
        driver = new FirefoxDriver();
        baseUrl = "http://robot.progideo.com/Accueil.php?seed=3";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testUntitledTestCase() throws Exception {
        driver.get("http://robot.progideo.com/Accueil.php?seed=3");
        driver.findElement(By.id("newCarte")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner gauche")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Tourner droite")).click();
        driver.findElement(By.linkText("Avancer")).click();
        driver.findElement(By.linkText("Avancer")).click();
        // ERROR: Caught exception [ERROR: Unsupported command [doubleClick | link=Avancer | ]]
        assertEquals("13", driver.findElement(By.id("yRobot")).getText());
        // ERROR: Caught exception [unknown command []]
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
