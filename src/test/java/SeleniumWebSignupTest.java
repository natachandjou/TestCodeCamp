import jdk.internal.net.http.common.SubscriptionBase;

import static java.lang.Thread.sleep;

public class SeleniumWebSignupTest {

    private WebDriver driver;
    private long millis;

    public void start() {
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://selenium-blog.herokuapp.com");
        sleep( 5000);
        driver.manage().window().maximaize();
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        driver.findElement(By.id("user_username")).sendKeys("ronke 10");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        sleep(5000);
        {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains(expectedUrl))
            System.out.println("Correct Webpage");
        else
            System.out.println("Wrong Webpage");
            sleep(5000);

    }

    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (!actualPageUrl.contains(expectedPageUrl)) {
            System.out.println("Wrong User1Page");
        } else {
            System.out.println("Correct User1Page");
        }
        sleep(5000);
    }
    @Test (priority = 3)
    public void logoutSucessfully(){
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        String expectedTitle = "AlphaBlog";
        String actualTitle = driver.getTitle();
        if(expectedTitle.contains(actualTitle))
           System.out.println("Correct Webpage");else
           System.out.println("Wrong Webpage");
    }

    @Test (priority = 4)
    public void negativeSignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        sleep(5000);
        driver.findElement(By.id("user_username")).sendKeys("ro");
        driver.findElement(By.id("user_email")).sendKeys("ronke7@mailinator.com");
        driver.findElement(By.id("user_password")).sendKeys("admin");
        driver.findElement(By.id("submit")).click();
        sleep(5000);
    }

    @AfterTest
    public void closeBrowser() {
        driver.quit();

    }



}

    private class WebDriver {
        public SubscriptionBase manage() {
            return null;
        }
    }

    private class ChromeDriver extends WebDriver {
    }
